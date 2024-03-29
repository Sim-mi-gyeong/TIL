package Chapter1.After;

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
		if (bag.hasInvitation()) {   // 자신의 가방 안에 초대장이 있는지 스스로 확인
			bag.setTicket(ticket);
			return 0L;
		} else {
			bag.setTicket(ticket);
			bag.minusAmount(ticket.getFee());
			return ticket.getFee();   // 이 금액만큼 매표소의 plusAmount()
		}
	}

}
