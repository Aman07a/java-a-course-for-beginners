package com.in28minutes.api.c;

import java.util.List;
import java.util.function.Predicate;

public class PredicateNotRunner {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(3, 4, 5, 67, 89, 88);
		Predicate<Integer> evenNumberPredicate = number -> number % 2 == 0;
		numbers.stream().filter(evenNumberPredicate.negate()).forEach(System.out::println);
	}

}
