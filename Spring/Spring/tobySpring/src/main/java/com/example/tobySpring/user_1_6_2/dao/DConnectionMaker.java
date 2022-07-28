package com.example.tobySpring.user_1_6_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Connection c = DriverManager.getConnection("", "", "");
		return c;
	}
}
