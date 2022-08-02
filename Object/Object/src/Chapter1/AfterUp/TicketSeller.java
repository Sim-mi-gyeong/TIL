package Chapter1.AfterUp;

/**
 * 매표소에서 초대장을 티켓으로 교환해 주거나, 티켓을 판매하는 역할 수행하는 판매원 클래스 - 자신이 일하는 매표소를 알고 있어야 함
 */
public class TicketSeller {

	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	/**
	 *  getTicketOffice() 메소드 제거
	 * - ticketOffice 의 가시성이 private + 접근 가능한 퍼블릭 메서드 존재 X
	 * -> 외부에서는, ticketOffice 에 직접 접근 불가
	 * -> ticketOffice 에 대한 접근은 오직 ticketSeller 안에만 존재
	 * -> 캡슐화(개념적/물리적으로 객체 내부의 세부적인 사항을 감추는 것)
	 */
	// public TicketOffice getTicketOffice() {
	// 	return ticketOffice;
	// }

	/**
	 * TicketSeller 가 TicketOffice 의 자율권을 침해하는 상황
	 * - TicketSeller 는 TicketOffice 에 있는 Ticket 을 마음대로 꺼내어 -> 자기 멋대로 Audience 에게 팔고 -> Audience 에게 받은 돈을 마음대로 TicketOffice 에 넣음
	 */
	// public void sellTo(Audience audience) {
	// 	ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
	// }
	public void sellTo(Audience audience) {
		ticketOffice.sellTicketTo(audience);
	}

}
