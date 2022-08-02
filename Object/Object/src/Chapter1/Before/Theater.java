package Chapter1.Before;

/**
 * 관람객을 소극장에 입장시키는 로직 처리 클래스
 * - 1. 예상을 빗나가 이해하기 어려우며,
 * - 2. 변경에 취약한 코드(지나치게 세부적인 사실에 의존하여 동작) -> 최소한의 의존성(변경에 대한 영향) 유지 + 불필요한 의존성 제거 필요
 * -> Theater 의 Audience 와 TicketSeller 에 대한 결합도 최소화(자율성 증가시키기)
 * 		- 관람객이 스스로 가방 안의 현금과 초대장을 처리
 * 		- 판매원이 스스로 매표소의 티켓과 판매 요금을 다루게 처리
 */
public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {

		if (audience.getBag().hasInvitation()) {
			// 초대장을 -> 티켓으로 교환해주기
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().setTicket(ticket);

		} else {
			// 티켓 금액만큼 -> 고객의 가방에서 현금을 빼고 / 그만큼 극장의 현금 추가
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().minusAmount(ticket.getFee());
			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
			// 티켓 전달
			audience.getBag().setTicket(ticket);

		}
	}
}
