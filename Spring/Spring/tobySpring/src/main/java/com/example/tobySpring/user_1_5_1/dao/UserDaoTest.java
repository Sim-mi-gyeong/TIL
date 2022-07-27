package com.example.tobySpring.user_1_5_1.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 애플리케이션 컨텍스트를 적용한 UserDaoTest
 */
public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		/**
		 * getBean() : ApplicationContext 가 관리하는 오브젝트 요청 메소드
		 *  - param "userDao" : Bean 의 이름 - userDao 라는 이름의 빈을 가져온다는 것 = DaoFactory 의 userDao() 메소드를 호출해서 -> 그 결과를 가져오는 것
		 *  - userDao 를 생성하는 방식/구성이 다른 메소드를 추가할 수 있어, 이름에 메소드 이름 지정
		 */
		UserDao dao = context.getBean("userDao", UserDao.class);
	}
}
