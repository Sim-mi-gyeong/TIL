package Chapter2.bookingSystem;

public class PercentDiscountPolicy extends DiscountPolicy {

	private double percent;

	public PercentDiscountPolicy(double percent, DiscountCondition ... conditions) {
		super(conditions);
		this.percent = percent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {   // 할인할 금액을 리턴 !
		return screening.getMovieFee().times(percent);
	}
}
