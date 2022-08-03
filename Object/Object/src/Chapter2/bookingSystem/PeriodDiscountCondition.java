package Chapter2.bookingSystem;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class PeriodDiscountCondition implements DiscountCondition {

	private DayOfWeek dayOfWeek;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public PeriodDiscountCondition(DayOfWeek dayOfWeek, LocalDateTime startTime, LocalDateTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
			startTime.compareTo(ChronoLocalDateTime.from(screening.getStartTime().toLocalTime())) <= 0 &&
			endTime.compareTo(ChronoLocalDateTime.from(screening.getStartTime().toLocalTime())) >= 0;
	}
}
