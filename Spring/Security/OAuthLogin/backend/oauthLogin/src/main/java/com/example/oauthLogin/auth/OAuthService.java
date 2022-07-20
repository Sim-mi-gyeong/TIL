package com.example.oauthLogin.auth;

import com.example.oauthLogin.auth.dto.AuthRepository;
import com.example.oauthLogin.auth.dto.OAuthAttributes;
import com.example.oauthLogin.jwt.JwtService;
import com.example.oauthLogin.member.Member;
import com.example.oauthLogin.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;
    private final AuthRepository authRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return null;
    }

    // 이미 저장된 정보에 대해 Update 처리
    private Member saveOrUpdate(OAuthAttributes attributes) {

        Member member = memberRepository.finaByEmail(attributes.getEmail())
            .orElse(attributes.toEntity());

        return memberRepository.save(member);
    }


}
