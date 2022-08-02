package com.example.tobySpring.Chapter2.Ch2_3_3.user.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.tobySpring.Chapter2.Ch2_3_3.user.dao.UserDao;
import com.example.tobySpring.Chapter2.Ch2_3_3.user.domain.User;

public class UserDaoTest {

	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.get("unknown_id");   // 이 메소드 실행 중 예외가 발생해야 함 -> 예외가 발생하지 않으면 테스트 실패
	}

	@Test
	public void andAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user1 = new User("gyumee", "박성철", "springno1");
		User user2 = new User("leegw700", "이길원", "springno2");
		User user3 = new User("bumjin", "박범진", "springno3");

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));

	}

	public static void main(String[] args) {
		// JUnitCore 클래스의 main 메소드 호출
		// 메소드 파라미터 : @Test 테스트 메소드를 가진 클래스의 이름
		JUnitCore.main("com.example.tobySpring.Chapter2.Ch2_3_2.user.dao.UserDaoTest");
	}
}
