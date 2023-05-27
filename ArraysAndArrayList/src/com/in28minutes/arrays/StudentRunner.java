package com.in28minutes.arrays;

public class StudentRunner {

	public static void main(String[] args) {
		Student student = new Student("Ranga", 97, 98, 100);

		int number = student.getNumberOfMarks();
		System.out.println("number of marks : " + number);
	}

}
