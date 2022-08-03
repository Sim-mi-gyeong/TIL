package Chapter2.bookingSystem;

/**
 * 고객(customer), 상영 정보(screening), 예매 요금(fee), 인원 수(audienceCount) 를 속성으로 포함하는 예매 클래스
 */
public class Reservation {

	private Customer customer;
	private Screening screening;
	private Money fee;
	private int audienceCount;

	public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
		this.customer = customer;
		this.screening = screening;
		this.fee = fee;
		this.audienceCount = audienceCount;
	}
}
