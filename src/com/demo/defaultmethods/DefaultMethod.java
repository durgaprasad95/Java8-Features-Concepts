package com.demo.defaultmethods;

public class DefaultMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TimeClient myTimeClient = new SimpleTimeClient();
		System.out.println("Current time: " + myTimeClient.toString());
		System.out.println("Time in California: " +
				myTimeClient.getZonedDateTime("Europe/Paris").toString());
	}

}
