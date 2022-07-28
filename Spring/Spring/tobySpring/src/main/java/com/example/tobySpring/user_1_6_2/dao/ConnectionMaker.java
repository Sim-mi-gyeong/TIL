package com.example.tobySpring.user_1_6_2.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
