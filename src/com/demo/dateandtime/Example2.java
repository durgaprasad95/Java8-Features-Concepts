package com.demo.dateandtime;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Get the zoned date/time
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(Clock.systemUTC());
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedDatetime);
		System.out.println(zonedDatetimeFromClock);
		System.out.println(zonedDatetimeFromZone);

		// Get duration between two dates
		final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);
		final Duration duration = Duration.between(from, to);
		System.out.println("Duration in days: " + duration.toDays());
		System.out.println("Duration in hours: " + duration.toHours());

		// Get period between two dates
		final LocalDate now = LocalDate.of(2014, Month.APRIL, 16);
		final LocalDate then = LocalDate.of(2015, Month.MAY, 24);
		final Period period = Period.between(now, then);
		System.out.println("Difference : " + period.getYears() + " Years " + period.getMonths() + " Months "
				+ period.getDays() + " Days");
	}

}
