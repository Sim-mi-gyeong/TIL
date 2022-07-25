package user4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {   // 더 이상 상속을 이용한 확장 방식을 사용할 필요가 없어 -> 추상 클래스로 만들 필요가 없음

	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.sql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/topy_spring?serverTimezone=UTC&characterEncoding=UTF-8", "root", "");
		return c;
	}
}
