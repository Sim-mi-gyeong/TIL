package user_1_4_2.dao;

public class UserDao {

	private ConnectionMaker connectionMaker;

	public UserDao(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}
}
