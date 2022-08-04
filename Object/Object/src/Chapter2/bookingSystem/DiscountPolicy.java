package Chapter2.bookingSystem;

public interface DiscountPolicy {

	Money calculateDiscountAmount(Screening screening);
}
