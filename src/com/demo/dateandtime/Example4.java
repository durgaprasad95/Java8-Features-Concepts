package com.demo.dateandtime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 29, 23, 59, 59);

		// use of get to extract the value of a field in a Date
		System.out.println(from.get(ChronoField.ERA));
		System.out.println(to.get(ChronoField.DAY_OF_MONTH));

		//
		System.out.println(from.range(ChronoField.ERA));
	}

}
