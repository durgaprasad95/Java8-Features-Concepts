package com.demo.dateandtime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Example5 {

	public static void main(String[] args) {
		final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 2, 34, 50);
		final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 21, 23, 59, 59);

		// Before Truncating
		System.out.println(to);

		// Truncates cuts down the fields below the field mentioned in the
		// parameter for the
		// given Date format
		System.out.println(to.truncatedTo(ChronoUnit.MINUTES));

		// Getting Date and Time individually from a LocalDateTime using 'to'
		// methods
		System.out.println("Date : " + to.toLocalDate() + " Time : " + to.toLocalTime());

		// Using 'at' methods
		System.out.println(to.toLocalDate());
		System.out.println((to.toLocalDate()).atTime(12, 23, 45));
		System.out.println((to.toLocalDate()).atStartOfDay());

		// Using 'with' in methods also called as Temporal Adjuster
		// 'with' actually changes one can say
		// replaces the part of time from 'this TIME ' to the same part of time
		// in the mentioned time format
		System.out.println(to.with(from));
		System.out.println(to.withYear(2020));
		System.out.println(to.with(ChronoField.YEAR, 2050));

		// following is called Temporal Query
		// executes the query given in the query parameters on the temporal
		// object
		System.out.println(to.query(LocalTime::from));
	}
}
