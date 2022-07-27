package user_1_4_2.dao;

public class DaoFactory {

	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}

	/**
	 * 각 DAO 를 생성하는 생성 메소드 추가 시 ConnectionMaker 구현 클래스를 선정하고 생성하는 코드의 중복 발생
	 * -> 분리해서 ConnectionMaker 타입의 오브젝트를 생성 -> 중복 제거
	 */
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
