package Chapter2.bookingSystem;

public class NoneDiscountPolicy implements DiscountPolicy {

	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
