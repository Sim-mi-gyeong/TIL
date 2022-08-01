package com.example.tobySpring.user_1_7_4.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {

	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}

	/**
	 * CountingConnectionMaker 타입의 오브젝트 생성
	 * -> realConnectionMaker() 메소드가 생성한 오브젝트를, connectionMaker() 메소드에서 만드는 오브젝트의 생성자를 통해 DI
	 */
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	// 실제 DB 커넥션을 만들어주는 DConnectionMaker 오브젝트 생성
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
}
