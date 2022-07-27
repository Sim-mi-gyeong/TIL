package user_1_4_2.dao;

public class MessageDao {

	private ConnectionMaker connectionMaker;

	public MessageDao(ConnectionMaker simpleConnectionMaker) {
		this.connectionMaker = simpleConnectionMaker;
	}
}
