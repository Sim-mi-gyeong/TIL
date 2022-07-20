package com.example.oauthLogin.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenInterceptor implements HandlerInterceptor {

	private final JwtService jwtService;

	/**
	 * JWT Token Interceptor
	 *  - WebMvcConfig 에서 설정한 uri 에 대해 Token 확인
	 */
}
