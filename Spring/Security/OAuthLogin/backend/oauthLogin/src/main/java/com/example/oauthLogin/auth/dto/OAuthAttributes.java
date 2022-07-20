package com.example.oauthLogin.auth.dto;

import com.example.oauthLogin.auth.AuthProvider;
import com.example.oauthLogin.exception.OAuth2AuthenticationProcessingException;
import com.example.oauthLogin.member.Member;
import com.example.oauthLogin.member.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * OAuth2 로그인을 통해서 가져온 OAuth2User 의 정보를 담아주기 위한 클래스
 */
@ToString
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes) throws OAuth2AuthenticationProcessingException {

        switch (AuthProvider.valueOf(registrationId.toLowerCase())) {
            case naver:
                return ofNaver(userNameAttributeName, attributes);
            case kakao:
                return ofKakao("id", attributes);
            case google:
                return ofGoogle(userNameAttributeName, attributes);
            default:
                throw new OAuth2AuthenticationProcessingException("Login with " + registrationId + " is not supported yet.");
        }
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {

        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // Kakao Login User 정보 요청
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        // kakao는 kakao_account 에 유저정보가 있다. (email)
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        // kakao_account 안에 또 profile 이라는 JSON 객체가 있다. (nickname, profile_image)
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return OAuthAttributes.builder()
                .name((String) kakaoProfile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();
    }
}
