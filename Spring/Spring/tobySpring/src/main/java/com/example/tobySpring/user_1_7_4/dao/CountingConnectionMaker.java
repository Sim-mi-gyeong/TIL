package com.example.tobySpring.user_1_7_4.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ConnectionMaker 인터페이스 구현 -> 내부에서 직접 DB 커넥션 생성 X
 * -> DAO 가 DB 커넥션을 가져올 때마다 호출하는 makeConnection() 에서 DB 연결횟수 카운터 증가
 * -> 자신의 관심사(DB 연결횟수 카운팅) 작업 후
 * -> 실제 DB 커넥션을 만들어주는 realConnectionMaker 에 저장된 ConnectionMaker 타입 오브젝트의 makerConnection() 호출해서
 * -> 그 결과를 DAO 에게 돌려줌
 */
public class CountingConnectionMaker implements ConnectionMaker {

	int cnt = 0;
	private ConnectionMaker realConnectionMaker;

	// 생성자
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		this.cnt ++;
		return realConnectionMaker.makeConnection();
	}

	public int getCnt() {
		return this.cnt;
	}
}
