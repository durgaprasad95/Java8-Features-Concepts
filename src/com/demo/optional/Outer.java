package com.demo.optional;

import java.util.Optional;

public class Outer {

	Nested nested;

	class Nested {
		Inner inner;

		class Inner {
			String foo = "Hello OPTIONAL";

		}
	}

	public static void main(String[] args) {
		Outer outer = new Outer();

		// Using multiple null checks
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
			System.out.println(outer.nested.inner.foo);
		}

		// Using Optional class for checking NULL
		Optional.of(new Outer()).flatMap(o -> Optional.ofNullable(o.nested)).flatMap(n -> Optional.ofNullable(n.inner))
				.flatMap(i -> Optional.ofNullable(i.foo)).ifPresent(System.out::println);
	}
}
