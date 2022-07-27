package user_1_4_1.dao;

/**
 * UserDaoTest 에 있던 UserDao, ConnectionMaker 관련 생성 작업을 -> DaoFactory 로 옮기고
 * UserDaoTest 에서는 UserDaoFactory 로 요청해서 -> 미리 만들어진 UserDao 오브젝트를 가져와 사용
 */
public class DaoFactory {

	/**
	 * 팩토리의 메소드 : UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지 결정
	 */
	public UserDao userDao() {
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}

	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
