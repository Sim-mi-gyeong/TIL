package com.example.tobySpring.user_1_6_4.sandbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.tobySpring.user_1_5_1.dao.DaoFactory;
import com.example.tobySpring.user_1_6_4.user.dao.UserDao;

public class SingletonTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

		System.out.println(context.getBean(UserDao.class));
		System.out.println(context.getBean(UserDao.class));
	}
}
