package user_1_3_2.dao;

import java.sql.Connection;
import java.sql.SQLException;

// 이 인터페이스를 사용하는 UserDao 입장 - ConnectionMaker 인터페이스 타입이 오브젝트라면,
// 어떤 클래스로 만들어졌든지 상관없이 -> makeConnection() 메소드를 호출하기만 하면 -> Connection 타입의 오브젝트를 만들어서 돌려줄 것 !
public interface ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
