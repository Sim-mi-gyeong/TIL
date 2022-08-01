package com.example.tobySpring.user_1_7_4.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoConnectionCountingTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);   // DAO 를 DL 방식으로 가져와 -> 여러 번 실행 가능

		// DAO 사용 코드

		/**
		 * DDL(의존관계 검색) 사용 -> 설정정보에 지정된 이름과 타입을 이용해 빈 가져오기 가능
		 *  - getBean("빈 이름", "빈 객체(타입)")
		 *  CountingConnectionMaker 에는, 그동안 DAO 를 통해 DB 커넥션을 요청한 횟수만큼 카운터가 증가해 있어야 함
		 */
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection Counter : " + ccm.getCnt());
	}
}
