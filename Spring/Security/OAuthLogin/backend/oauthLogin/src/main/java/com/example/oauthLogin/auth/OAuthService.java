package com.example.oauthLogin.auth;

import com.example.oauthLogin.auth.dto.AuthEntity;
import com.example.oauthLogin.auth.dto.AuthRepository;
import com.example.oauthLogin.auth.dto.OAuthAttributes;
import com.example.oauthLogin.jwt.JwtService;
import com.example.oauthLogin.member.model.Member;
import com.example.oauthLogin.member.model.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;
    private final AuthRepository authRepository;

    /**
     * OAuth 요청 -> 인가 코드 발급 -> Access Token 발급 -> 사용자 정보 요청
     * @param userRequest
     * @return
     * @throws OAuth2AuthenticationException
     */
    @SneakyThrows
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        log.debug("[OAuthUserRequest AccessToken] : {}", userRequest.getAccessToken().getTokenValue());
        log.debug("[OAuthUserRequest] : {}", userRequest.getAdditionalParameters());
        log.debug("[OAuthUserRequest] : {}", oAuth2User.getAttributes());

        // Social Service
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("서비스 registrationId : " + registrationId);
        String userNameAttribute = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttribute, oAuth2User.getAttributes());
        Member member = saveOrUpdate(attributes);   // email 로 Member 조회 후 업데이트 || 회원가입

        // 로그인 시 토큰 생성
        saveOrUpdateAuthEntity(member);

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    // 이미 저장된 정보에 대해 Update 처리
    private Member saveOrUpdate(OAuthAttributes attributes) {

        Member member = memberRepository.findByEmail(attributes.getEmail())
            .orElse(attributes.toEntity());

        return memberRepository.save(member);
    }

    private void saveOrUpdateAuthEntity(Member member) {
        if (!authRepository.existsByMemberId(member.getId())) {
            String jwt = jwtService.createJwt(member.getId());
            String refreshToken = jwtService.createRefreshToken(member.getId());
            authRepository.save(new AuthEntity(jwt, refreshToken, member.getId()));
        }
    }
}
