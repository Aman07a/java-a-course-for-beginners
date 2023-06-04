package com.in28minutes.api.f;

public class SwitchExpressionRunner {

	public static String findDayOfTheWeek(int day) {
		String dayOfWeek = "";

		switch (day) {
		case 0:
			dayOfWeek = "Sunday";
			break;
		case 1:
			dayOfWeek = "Monday";
			break;
		case 2:
			dayOfWeek = "Tuesday";
			break;
		case 3:
			dayOfWeek = "Wednesday";
			break;
		default:
			throw new IllegalArgumentException("Invalid Option" + day);
		}

		return dayOfWeek;
	}

	public static String findDayOfTheWeekWithSwitchExpression(int day) {
		String dayOfWeek;

		switch (day) {
		case 0:
			System.out.println("Do Some complex logic here");
			dayOfWeek = "Sunday";
			break;
		case 1:
			dayOfWeek = "Monday";
			break;
		case 2:
			dayOfWeek = "Tuesday";
			break;
		case 3:
			dayOfWeek = "Wednesday";
			break;
		default:
			throw new IllegalArgumentException("Invalid Option" + day);
		}

		return dayOfWeek;
	}

	public static void main(String[] args) {

	}

}
