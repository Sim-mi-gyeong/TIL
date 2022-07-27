package user_1_4_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.sql.jdbc.Driver");
		Connection c = DriverManager.getConnection("", "", "");

		return c;
	}
}
