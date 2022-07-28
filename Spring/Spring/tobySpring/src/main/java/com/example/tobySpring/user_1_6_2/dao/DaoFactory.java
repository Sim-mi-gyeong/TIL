package com.example.tobySpring.user_1_6_2.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   // Application Context 또는 Bean Factory 가 사용할 설정정보라는 표시
public class DaoFactory {

	@Bean   // 오브젝트 생성을 담당하는 IoC 용 메소드라는 표시
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}