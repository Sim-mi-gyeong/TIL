package com.example.oauthLogin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.oauthLogin.jwt.JwtTokenInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

	private final JwtTokenInterceptor jwtTokenInterceptor;

	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		// Interceptor Scope
		interceptorRegistry.addInterceptor(jwtTokenInterceptor).addPathPatterns("/token/test/**");
	}
}
