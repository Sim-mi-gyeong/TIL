package com.example.tobySpring.user_1_6_4.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
