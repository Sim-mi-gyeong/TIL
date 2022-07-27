package com.example.tobySpring.user_1_5_1.dao;

public class UserDao {

	private ConnectionMaker connectionMaker;

	public UserDao(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}
}
