package user_1_3_3.dao;

public class UserDao {

	private ConnectionMaker connectionMaker;

	/**
	 * 제3의 오브젝트(=클라이언트)가 USreDao 오브젝트가 사용할 수 있는 ConnectionMaker 오브젝트를 전달해주도록 함
	 * -> UserDao 에는 ConnectionMaker 의 구현 클래스 이름인 DConnectionMaker 가 사라짐
	 */
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
}
