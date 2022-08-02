package Chapter1.After;

/**
 * 관객의 소지품을 보관하는 Bag 클래스
 */
public class Bag {

	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public boolean hasInvitation() {   // 초대장 보유 여부 판단
		return invitation != null;
	}

	public boolean hasTicket() {   // 티켓 소유 여부 판단
		return ticket != null;
	}

	public void setTicket(Ticket ticket) {   // 초대장을 티켓으로 교환
		this.ticket = ticket;
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}

	/**
	 * 1. 이벤트에 당첨된 관람객의 가방 안 - 현금 / 초대장
	 * 2. 이벤트에 당첨되지 않은 관람객의 가방 안 - 초대장 X / 현금
	 * -> Bag 의 인스턴스를 생성하는 시점에 제약 강제하는 생성자 추가
	 */
	public Bag(long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

}
