package Chapter1.Before;

/**
 * 관람객 구현 클래스
 */
public class Audience {

	private Bag bag;   // 소지품 보관을 위해 가방 소지 가능

	public Audience(Bag bag) {
		this.bag = bag;
	}

	public Bag getBag() {
		return bag;
	}
}
