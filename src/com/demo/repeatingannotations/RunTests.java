package com.demo.repeatingannotations;

import java.lang.reflect.Method;

import com.demo.repeatingannotations.Foo.Test;

public class RunTests {

	public static void main(String[] args) throws Exception {
		int passed = 0, failed = 0;
		// This takes the command line arguments
		// which consists of the class file location
		for (Method m : Class.forName(args[0]).getMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				try {
					m.invoke(null);
					passed++;
				} catch (Throwable ex) {
					System.out.printf("Test %s failed: %s %n", m, ex.getCause());
					failed++;
				}
			}
		}
		System.out.printf("Passed: %d, Failed %d%n", passed, failed);
	}

}
