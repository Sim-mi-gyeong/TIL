package Chapter1.AfterUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 관람객에게 판매할 티켓과 + 티켓의 판매 금액이 보관되어 있는 매표소 클래스
 */
public class TicketOffice {

	// 판매하거나, 교환해줄 티켓의 목록
	private List<Ticket> tickets = new ArrayList<>();
	// 판매 금액
	private Long amount;

	public TicketOffice(Long amount, Ticket... tickets) {
		this.amount = amount;
		this.tickets.addAll(Arrays.asList(tickets));
	}

	// 티켓 판매 메소드 - 편의를 위해, 컬렉션에서 첫 번째 위치에 저장된 Ticket 반환
	private Ticket getTicket() {
		return tickets.remove(0);
	}

	// 판매 금액 차감
	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
	// 판매 금액 가감
	private void plusAmount(Long amount) {
		this.amount += amount;
	}

	public void sellTicketTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}
}
