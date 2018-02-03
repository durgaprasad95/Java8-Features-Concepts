package com.demo.defaultmethods;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {
	void setTime(int hour, int minute, int second);

	void setDate(int day, int month, int year);

	void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

	LocalDateTime getLocalDateTime();

	// just like any other static method
	// this does not need any objects to call
	static ZoneId getZoneId(String zoneString) {
		try {
			return ZoneId.of(zoneString);
		} catch (DateTimeException e) {
			System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead.");
			return ZoneId.systemDefault();
		}
	}

	// instead of the following declaration we define the method by using the
	// keyword 'default'
	// ZonedDateTime getZonedDateTime(String zoneString);
	default ZonedDateTime getZonedDateTime(String zoneString) {
		return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
	}
}
