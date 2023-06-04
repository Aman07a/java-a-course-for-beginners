package com.in28minutes.api.e;

import java.util.List;
import java.util.stream.Stream;

public class TypeInferencesRunner {

	public static void main(String[] args) {

		List<String> names1 = List.of("Ranga", "Ravi");
		List<String> names2 = List.of("John", "Adam");

		final List<List<String>> names = List.of(names1, names2);

		names.stream().forEach(System.out::println);

		for (String name : names1) {
			System.out.println(name);
		}

		Stream<String> filter = List.of("Ranga", "Ravi").stream().filter(s -> s.length() < 5);
		filter.forEach(System.out::println);

	}

}
