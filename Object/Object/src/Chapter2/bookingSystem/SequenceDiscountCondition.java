package Chapter2.bookingSystem;

public class SequenceDiscountCondition implements DiscountCondition {

	private int sequence;   // 할인 여부 판단을 위한 순번

	public SequenceDiscountCondition(int sequence) {
		this.sequence = sequence;
	}

	// 파라미터로 전달된 Screening 의 상영 순번과 일치할 경우 -> 할인 가능
	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
