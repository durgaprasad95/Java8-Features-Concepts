package com.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatefulLambda {

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		final List<Integer> listOfIntegers = Arrays.asList(intArray);

		final List<Integer> serialStorage = new ArrayList<>();
		System.out.println("Serial stream:");
		listOfIntegers.stream()

				// Don't do this! It uses a stateful lambda expression.
				.map(e -> {
					serialStorage.add(e);
					return e;
				})

				.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		// Should be written like this
		serialStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("Parallel stream:");
		List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
		listOfIntegers.parallelStream()

				// Don't do this! It uses a stateful lambda expression.
				.map(e -> {
					parallelStorage.add(e);
					return e;
				})

				.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		// Should be written like this
		parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		// For Unsafe thread objects like Collections check the following Output
		System.out.println("Parallel stream and Non Synchronized :");
		List<Integer> parallelStorage2 = new ArrayList<>();
		listOfIntegers.parallelStream()

				// Don't do this! It uses a stateful lambda expression.
				.map(e -> {
					parallelStorage2.add(e);
					return e;
				})

				.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		// Should be written like this
		parallelStorage2.parallelStream().forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

	}
}