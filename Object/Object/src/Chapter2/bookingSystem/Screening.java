package Chapter2.bookingSystem;

import java.time.LocalDateTime;

/**
 *  클래스 내부와 외부 구분 - 경계의 명확성이, 객체의 자율성을 보장
 *  - 인스턴스 변수의 가시성 : private
 *  - 매서드 가시성 : public
 */
public class Screening {

	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	public LocalDateTime getStartTime() {
		return whenScreened;
	}

	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}

	public Money getMovieFee() {
		return movie.getFee();
	}

	/**
	 * 영화 예매 후 예매 정보를 담고있는 Reservation 인스턴스 생성 후 반환
	 *  - Customer : 예매자 정보 포함
	 *  - audienceCount : 예매 인원 수
	 */
	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);   // [고객, 상영정보, 요금, 인원 수] 를 생성자 파라미터로 갖는 예매 클래스의 오브젝트 생성
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);   // calculateMovieFee(this) 의 반환값(인당 영화 예매 금액) * 인원 수 => 전체 지불 금액
	}
}
