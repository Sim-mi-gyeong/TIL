package user_1_4_2.dao;

public class AccountDao {

	private ConnectionMaker connectionMaker;
	public AccountDao(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}
}
