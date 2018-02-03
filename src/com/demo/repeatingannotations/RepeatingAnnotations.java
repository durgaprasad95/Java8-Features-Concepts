package com.demo.repeatingannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	};

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filtering {
		int intVal();
	};

	@Filter("filter1")
	@Filter("filter2")
	@Filter("filter2")
	@Filtering(intVal = 122)
	public interface Filterable {
	}

	public static void main(String[] args) {
		for (Filtering x : Filterable.class.getAnnotationsByType(Filtering.class)) {
			// System.out.println(Filterable.class.getSimpleName());
			System.out.println(x.intVal());
		}
	}

}
