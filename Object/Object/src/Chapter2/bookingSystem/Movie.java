package Chapter2.bookingSystem;

import java.time.Duration;

/**
 * 제목(title), 상영시간(runningTime), 요금(fee), 할인 정책(discountPolicy) 을 속성으로 갖는 영화 클래스
 */
public class Movie {

	private String title;
	private Duration runningTime;
	private Money fee;
	private DiscountPolicy discountPolicy;

	/**
	 * 합성을 통한 실행 시점에 할인 정책 변경이 가능한 메서드
	 */
	public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}
	public Money getFee() {
		return fee;
	}

	/**
	 * discountPolicy 에 calculateDiscountAmount 메시지를 전송해 -> 할인 요금 반환 받음
	 * -> Movie 는 기본 요금인 fee 에서 반환된 할인 요금 차감 (fee - 반환 할인 요금)
	 */
	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));   // 어떤 할인 정책을 사용할 것인지 결정하는 코드 X -> 추상화 기반의 상속(inheritance) 과 다형성
	}
}
