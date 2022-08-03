package Chapter2.bookingSystem;

public class AmountDiscountPolicy extends DiscountPolicy {

	private Money discountAmount;

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}
	@Override
	protected Money getDiscountAmount(Screening screening) {   // 할인할 금액을 리턴 !
		return discountAmount;
	}
}
