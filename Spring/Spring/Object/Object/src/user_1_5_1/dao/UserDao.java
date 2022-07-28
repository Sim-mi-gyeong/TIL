package user_1_5_1.dao;

import user_1_5_1.dao.DConnectionMaker;

public class UserDao {

	private static UserDao INSTANCE;
	private ConnectionMaker connectionMaker;

	private UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	public static synchronized UserDao getInstance() {
		if (INSTANCE == null) INSTANCE = new UserDao(connectionMaker());
		return INSTANCE;
	}

	public static ConnectionMaker connectionMaker() {
		return (ConnectionMaker) new DConnectionMaker();
	}
}
