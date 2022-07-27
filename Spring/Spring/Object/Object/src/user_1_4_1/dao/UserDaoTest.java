package user_1_4_1.dao;

import java.sql.SQLException;

import user_1_3_2.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// UserDaoFactory 의 userDao() 메소드 호출 -> DConnectionMaker 를 사용해 DB커넥션을 가져오도록 설정된 UserDao 오브젝트를 돌려줌
		UserDao dao = new DaoFactory().userDao();

		User user = new User();
		user.setId("smegyeong");
		user.setName("심미경");
		user.setPassword("student");

		dao.add(user);

		System.out.println(user.getId() + " 등록 성공");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회 성공");
	}
}
