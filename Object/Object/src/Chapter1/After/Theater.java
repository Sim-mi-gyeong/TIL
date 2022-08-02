package Chapter1.After;

public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		/**
		 * TicketOffice 에 접근하는 모든 코드를 -> TicketSeller 내부로
		 * -> 수정된 Theater 클래스 어디서도 ticketOffice 에 접근하지 X
		 * -> Theater 는 ticketOffice 가 tickerSeller 내부에 존재한다는 사실을 알지 못함
		 *
		 * Theater 는, 오직 TicketSeller 의 인터페이스에만 의존
		 * TicketSeller 가 내부에 TicketOffice 인스턴스를 포함하는 것은 구현의 영역
		 * -> 객체를 인터페이스와 구현으로 나누고, 인터페이스만을 공개 : 객체 사이의 결합도 낮추고, 변경하기 쉬운 코드 작성 위함
	 */
		ticketSeller.sellTo(audience);
	}
}
