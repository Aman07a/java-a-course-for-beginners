package com.in28minutes.ifstatement.examples;

public class IfStatementRunner {

	public static void main(String[] args) {
		int i = 24;
		// i = 25;
		// i = 24;
		// i is neither 25 or 24;

		if (i == 25) {
			System.out.println("i == 25");
		} else if (i == 24) {
			System.out.println("i = 24");
		} else if (i == 23) {
			System.out.println("i = 23");
		} else {
			System.out.println("i != 24 and i != 25 and i != 23");
		}
	}
}
