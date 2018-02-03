package com.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapUsage {

	public static void main(String[] args) {
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		// for (Foo x : foos) {
		// System.out.println(x.name);
		// for (Bar y : x.bars)
		// System.out.println(y.name);
		// }

		foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
		System.out.println(" The Following Code produces same Above result");

		// Entire above Code can be shrinked to the following One
		IntStream.range(1, 4)
				.mapToObj(i -> new Foo("Foo" + i)).peek(f -> IntStream.range(1, 4)
						.mapToObj(i -> new Bar("Bar" + i + " <- " + f.name)).forEach(f.bars::add))
				.flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
	}
}
