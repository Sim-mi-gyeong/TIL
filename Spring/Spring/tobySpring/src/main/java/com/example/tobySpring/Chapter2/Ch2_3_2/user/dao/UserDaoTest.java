package com.example.tobySpring.Chapter2.Ch2_3_2.user.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.tobySpring.Chapter2.Ch2_3_2.user.domain.User;

public class UserDaoTest {

	@Test
	public void andAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		User user = new User();
		user.setId("gyumee");
		user.setName("박성철");
		user.setPassword("springno1");

		dao.add(user);
		assertThat(dao.getCount(), is(1));

		User user2 = dao.get(user.getId());

		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}

	public static void main(String[] args) {
		// JUnitCore 클래스의 main 메소드 호출
		// 메소드 파라미터 : @Test 테스트 메소드를 가진 클래스의 이름
		JUnitCore.main("com.example.tobySpring.Chapter2.Ch2_3_2.user.dao.UserDaoTest");
	}
}
