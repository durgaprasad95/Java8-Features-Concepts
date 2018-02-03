package com.demo.streams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.lambda.Person;

public class ParallelAndSerial {
	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		Person p1 = new Person();
		p1.setName("durga prasad");
		p1.setBirthday(new Date(95, 1, 11));
		Person p2 = new Person();
		p2.setName("Akarsh");
		p2.setBirthday(new Date(94, 6, 3));
		persons.add(p1);
		persons.add(p2);
		Person p3 = new Person();
		p3.setName("Max");
		p3.setBirthday(new Date(95, 5, 17));
		persons.add(p3);
		Person p4 = new Person();
		p4.setName("Mahi");
		p4.setBirthday(new Date(95, 10, 11));
		persons.add(p4);

		// Table of Person's Name and Person's Age
		persons.stream().forEach(p -> System.out.println(p.getAge() + " " + p.getName()));

		// Using Reduce on a Serial Stream
		Integer SerialAgeSum = persons.stream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p.getName());
			return sum += p.getAge();
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});
		System.out.println(SerialAgeSum);

		// Using Reduce on a Parallel Stream
		Integer ParallelAgeSum = persons.parallelStream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p.getName());
			return sum += p.getAge();
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});
		System.out.println(ParallelAgeSum);
	}
}
