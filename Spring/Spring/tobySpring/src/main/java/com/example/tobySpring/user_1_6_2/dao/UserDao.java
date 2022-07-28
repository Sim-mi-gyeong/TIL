package com.example.tobySpring.user_1_6_2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.tobySpring.user_1_6_2.domain.User;

public class UserDao {

	/**
	 * 초기에 설정하면 -> 사용중에는 바뀌지 않는 읽기 전용 인스턴스 변수
	 */
	private ConnectionMaker connectionMaker;
	/**
	 * 매번 새로운 값으로 바뀌는 정보를 담은 인스턴스 변수 -> 추후 문제 발생 가능
	 */
	private Connection c;
	private User user;

	public UserDao(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}

	private User get(String id) throws ClassNotFoundException, SQLException {
		this.c = connectionMaker.makeConnection();

		PreparedStatement ps = c
			.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();

		this.user = new User();
		this.user.setId(rs.getString("id"));
		this.user.setName(rs.getString("name"));
		this.user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return this.user;

	}

}
