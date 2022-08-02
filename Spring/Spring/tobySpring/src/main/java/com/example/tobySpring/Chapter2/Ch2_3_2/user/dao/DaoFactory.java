package com.example.tobySpring.Chapter2.Ch2_3_2.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.example.tobySpring.Chapter2.Ch2_2_2.user.dao.UserDao;

@Configuration
public class DaoFactory {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

		// dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		// Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		// dataSource.setDriverClass(driverClass);
		// dataSource.setDriverClass((Class<? extends Driver>)Class.forName("com.mysql.jdbc.Driver"));
		dataSource.setUrl("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}

	@Bean
	public com.example.tobySpring.Chapter2.Ch2_2_2.user.dao.UserDao userDao() {
		com.example.tobySpring.Chapter2.Ch2_2_2.user.dao.UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
}
