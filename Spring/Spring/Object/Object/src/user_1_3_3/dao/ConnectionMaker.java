package user_1_3_3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {
	public abstract Connection makeConnection() throws ClassNotFoundException, SQLException;
}
