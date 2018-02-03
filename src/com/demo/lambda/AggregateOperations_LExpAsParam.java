package com.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AggregateOperations_LExpAsParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<>();
		Person p1 = new Person();
		p1.setName("durga prasad");
		p1.setEmailAddress("Sankaraganti");
		p1.setGender(Person.Sex.MALE);
		p1.setBirthday(new Date(95, 1, 11));
		Person p2 = new Person();
		p2.setName("Akarsh");
		p2.setEmailAddress("Bachu");
		p2.setGender(Person.Sex.MALE);
		p2.setBirthday(new Date(95, 0, 11));
		persons.add(p1);
		persons.add(p2);
		persons.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
				.map(p -> p.getEmailAddress()).forEach(emailAddress -> System.out.println(emailAddress));
		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		Person[] personsArray = persons.toArray(new Person[persons.size()]);
		Arrays.sort(personsArray, myComparisonProvider::compareByAge);
		for (Person p : personsArray)
			System.out.println(p.getName());
		Arrays.sort(personsArray);
	}

}
