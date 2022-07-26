package user_1_3_2.dao;

import java.sql.Connection;
import java.sql.SQLException;

import user_1_3_2.domain.User;

public class UserDao {

	private ConnectionMaker connectionMaker;

	public UserDao() {
		/**
		 *  DConnectionMaker 클래스의 생성자를 호출해서 오브젝트 생성하는 코드 존재
		 *  - UserDao 에서는 모든 곳에서 인터페이스를 이용하도록 만들어 -> DB 커넥션 제공 클래스에 대한 구체적 정보 모두 제거 가능
		 *  - But, 초기에, 한 번 어떤 클래스의 오브젝트를 사용할지를 결정하는 생성자 코드는 제거하지 않고 존재
		 */
		this.connectionMaker = new DConnectionMaker();
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
	}

	public User get() throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		User user = new User();

		return user;
	}
}
