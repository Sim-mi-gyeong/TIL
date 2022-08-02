package com.example.tobySpring.Chapter2.Ch2_2_2.user.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.example.tobySpring.Chapter2.Ch2_2_2.user.domain.User;

public class UserDaoTest {

	@Test
	public void andAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("gyumee");
		user.setName("박성철");
		user.setPassword("springno1");

		dao.add(user);

		User user2 = dao.get(user.getId());

		// assertTant(" ", " ") : 첫 번째 파라미터의 값을 - 뒤에 나오는 매처(matcher) 라고 불리는 조건으로 비교해서
		// 일치하면 -> 다음으로 / 일치하지 않으면 -> 테스트 실패
		// is() : 매처의 일종 -> equals() 로 비교해주는 기능
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}

	public static void main(String[] args) {
		// JUnitCore 클래스의 main 메소드 호출
		// 메소드 파라미터 : @Test 테스트 메소드를 가진 클래스의 이름
		JUnitCore.main("com.example.tobySpring.Chapter2.Ch2_2_2.user.dao.UserDaoTest");
	}
}
