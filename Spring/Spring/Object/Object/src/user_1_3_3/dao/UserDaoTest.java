package user_1_3_3.dao;

import java.sql.SQLException;

public class UserDaoTest {

	// 관계 설정 책임이 추가된 UserDao 클라이언트인 main() 메소드
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// UserDao 가 사용할 ConnectionMaker 구현 클래스를 결정하고, 오브젝트를 생성함
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao dao = new UserDao(connectionMaker);
	}
}
