package Chapter1.AfterUp;

/**
 * 관람객 구현 클래스
 */
public class Audience {

	private Bag bag;   // 소지품 보관을 위해 가방 소지 가능

	public Audience(Bag bag) {
		this.bag = bag;
	}

	// public Bag getBag() {
	// 	return bag;
	// }

	/**
	 * Audience 클래스에서, Bag 의 존재를 내부로 캡슐화
	 * -> TicketSeller 가 Audience 의 인터페이스에만 의존하도록 - TicketSeller 가 buy 메서드 호출하도록 변경
	 */

	public Long buy(Ticket ticket) {
		// Bag 의 구현 캡슐화에 따른 Audience 를 Bag 의 구현이 아닌, 인터페이스에만 의존하도록 수정
		return bag.hold(ticket);
	}

}
