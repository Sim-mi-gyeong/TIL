package Chapter1.Before;

/**
 * 매표소에서 초대장을 티켓으로 교환해 주거나, 티켓을 판매하는 역할 수행하는 판매원 클래스 - 자신이 일하는 매표소를 알고 있어야 함
 */
public class TicketSeller {

	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	public TicketOffice getTicketOffice() {
		return ticketOffice;
	}

}
