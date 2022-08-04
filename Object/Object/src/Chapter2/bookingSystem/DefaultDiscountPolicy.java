package Chapter2.bookingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 두 가지 할인 정책 클래스 코드가 유사하고, 할인 요금 계산 방식만 조금 다름
 * -> 두 클래스 사이의 중복 코드 제거를 위해 공통 코드를 보관하는, 추상 클래스(abstract class)로 구현
 *    - 실제 애플리케이션에서는, DiscountPolicy 의 인스턴스를 생성할 필요 X
 */

/**
 * DiscountPolicy 는 [할인 여부] 와 요굼 계산에 필요한 전체적인 흐름은 정의하지만,
 * 실제로 요금 계산 부분은 추상 메서드 getDiscountAmount 에 위임 -> DiscountPolicy 를 상속받은 자식 클래스에서 오버라이딩한 메서드가 실행될 것
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

	private List<DiscountCondition> conditions = new ArrayList<>();   // 하나의 할인 정책 : 여러 개의 할인 조건 포함 가능


	public DefaultDiscountPolicy(DiscountCondition ... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	/**
	 * 전체 할인 조건에 대해 차례대로 DiscountCondition 의 isSatisfiedBy 메서드 호출
	 * -> 할인 조건을 만족하는 DiscountCondition 이 하나라도 존재하는 경우 -> 추상 메서드 getDiscountAmount 를 호출해 -> 할인 요금 계산
	 * -> 만족하는 할인 조건 X -> 할인 요금으로 0원 반환
	 */
	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition each : conditions) {
			if (each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}

	abstract protected Money getDiscountAmount(Screening screening);

}
