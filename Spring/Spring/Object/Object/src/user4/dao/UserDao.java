package user4.dao;

public class UserDao {
	private SimpleConnectionMaker simpleConnectionMaker;

	public UserDao() {   // 상태를 관리하는 것이 아니므로 -> 한 번만 만들어 인스턴스 변수에 저장해두고 -> 메소드에서 사용하도록 함
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
}
