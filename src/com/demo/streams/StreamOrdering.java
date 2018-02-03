package com.demo.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOrdering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Stream Ordering is used in case of making our operations optimum
		Stream.of("d2", "b1", "a2", "b1", "a2", "c").parallel().map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});

		// Threads Assigning by ForkJoinPool.commonPool() static method in a
		// parallelStream
		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}

}
