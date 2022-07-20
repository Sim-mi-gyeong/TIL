package com.example.oauthLogin.auth.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jwt;

    private String refreshToken;

    private Long memberId;

    @Builder
    public AuthEntity(String jwt, String refreshToken, Long memberId) {
        this.jwt = jwt;
        this.refreshToken = refreshToken;
        this.memberId = memberId;
    }

    public void refreshUpdate(String refreshToken) {
        this.refreshToken = refreshToken;
    }


}
