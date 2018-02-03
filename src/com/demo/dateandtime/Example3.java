package com.demo.dateandtime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

		// Checking Occurrence of date w.r.f to Other
		if (from.isAfter(to))
			System.out.println("from IS AFTER to IN TIMELINE");
		else
			System.out.println("from IS BEFORE to IN TIMELINE");

		// Arithmetic Operations on date
		System.out.println(to.plusHours(1));

		// getting a particular day of month or month of year or anything
		// returns int or long
		System.out.println(to.getDayOfMonth());

		// 2nd Parameter is Temporal Unit which may be
		// NANOS, MICROS, MILLIS, SECONDS, MINUTES, HOURS and HALF_DAYS, DAYS,
		// WEEKS, MONTHS, YEARS, DECADES, CENTURIES, MILLENNIA and ERAS
		System.out.println(from.until(to, ChronoUnit.DAYS));

		// Alternate to the above line
		System.out.println(ChronoUnit.DAYS.between(from, to));
	}

}
