package user3.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// D 사의 DB Connection 생성 코드
		return null;
	}
}
