package com.demo.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Example6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		LocalTime time = LocalTime.parse("02:00", formatter);
		LocalDate date = LocalDate.of(2000, 1, 1);
		LocalDateTime dateTime = date.atTime(time);
		System.out.println(dateTime);
	}

}
