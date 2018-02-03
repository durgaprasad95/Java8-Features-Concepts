package com.demo.optional;

import java.util.Optional;

public class OptionalClassUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// USAGE 1
		Optional<String> fullName = Optional.ofNullable(null);
		System.out.println("Full Name is set? " + fullName.isPresent());
		System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
		System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
		// USAGE 2
		String m = "enter something";
		Optional<String> firstName = Optional.of("Tom");
		System.out.println("First Name is set? " + firstName.isPresent());
		System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
		System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
		firstName.ifPresent((String) -> System.out.println(m));
	}

}
