package com.in28minutes.api.g;

public class TextBlocksRunner {

	public static void main(String[] args) {

		String str1 = "fsadfjklasjf";
		String str = "\"Line 1\"\n" + "   \"Line 2\"\n" + "   Line 3\n" + "       Line 4\n" + "       Line 5\n"
				+ "Line 6";

		String textBlock = "Line 1: %s\n" + "Line 2: %s\n" + "Line 3\n" + "Line 4\n";
		textBlock = String.format(textBlock, "Some Value", "Some Other Value");

		System.out.print(textBlock);

	}
}
