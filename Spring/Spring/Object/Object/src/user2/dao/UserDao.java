package user2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user2.domain.User;

public class UserDao {

	public void add(User user) throws ClassNotFoundException, SQLException {

		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement(
			"insert into users(id, name, password) values(?, ?, ?)"
		);

		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {

		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
			"insert into users(id, name, password) values(?, ?, ?)"
		);

		// Parameter 로 전달된 id 를 Statement 의 index = 1 로 설정
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();

		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}


	// JDBC API 가 만들어내는 예외(Exception) 를 잡아서 직접 처리하거나
	// "메소드에 throws 를 선언해 예외가 발생하면 메소드 밖으로 던지게 함"
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();

		User user = new User();
		user.setId("smegyeong");
		user.setName("심미경");
		user.setPassword("student");

		dao.add(user);

		System.out.println(user.getId() + " - 등록 성공");

		User user2 = dao.get(user.getId());
		System.out.println("이름 : " + user2.getName());
		System.out.println("비밀번호 : " + user2.getPassword());

		System.out.println(user2.getId() + " - 등록 성공");
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/topy_spring?serverTimezone=UTC&characterEncoding=UTF-8", "root", "");
		return c;
	}
}