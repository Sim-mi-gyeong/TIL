package com.example.SessionLoginTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.SessionLoginTest.service.UserDetailServiceImpl;

import lombok.RequiredArgsConstructor;
// 인증 및 권한 처리를 위한 SecurityConfig
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private final UserDetailServiceImpl userDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/registry", "/login", "/css/**").permitAll()
			.antMatchers("/member/**").authenticated()   // 일반 사용자 접근 가능
			.antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")   // 매니저, 관리자 접근 가능
			.antMatchers("/admin/**").hasRole("ADMIN");   // 관리자만 접근 가능

		// 인증 필요 시 로그인 페이지와, 로그인 성공 시 redirect 경로 지정
		http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
		// 로그인이 수행될 uri 매핑(POST 요청이 기본)
		http.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/", true);
		// 인증된 사용자이지만 + 인가되지 않은 경로에 접근 시 redirect 할 uri 지정
		http.exceptionHandling().accessDeniedPage("/forbidden");
		// 로그아웃
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

		// 로그인 처리 수행
		http.userDetailsService(userDetailService);

	}
}
