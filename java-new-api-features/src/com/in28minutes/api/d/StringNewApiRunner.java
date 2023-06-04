package com.in28minutes.api.d;

class SampleClass {
	String str = null;
}

public class StringNewApiRunner {

	public static void main(String[] args) {

		System.out.println(" ".trim().isEmpty());
		System.out.println(" L R ".trim().replace(" ", "@"));
		System.out.println(" L R ".replaceFirst("^\\s+", "").replace(" ", "@"));
		System.out.println(" L R ".replaceAll("\\s+$", "").replace(" ", "@"));
		for (String line : "Line1\nLine2\nLine3\nLine4".split("\\n")) {
			System.out.println(line);
		}

		System.out.println("UPPER".substring(2));
		System.out.printf("My name is %s. My age is %d.", "Ranga", 25);

		SampleClass sample = new SampleClass();
		String str = null;

		if (sample.str != null) {
			System.out.println(sample.str.trim().isEmpty());
		} else {
			System.out.println("sample.str is null");
		}

		if (str != null) {
			System.out.println(str.trim().isEmpty());
		} else {
			System.out.println("str is null");
		}

	}

}
