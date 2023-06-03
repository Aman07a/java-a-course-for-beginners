package com.in28minutes.tips.access.package1;

class Player {
	private String name;
	private static int count = 0;

	public Player(String name) {
		super();
		this.name = name;
		count++;
	}

	public int getCount() {
		return count;
	}

}

public class StaticModifierRunner {

	public static void main(String[] args) {

		Player player1 = new Player("Ronaldo");
		System.out.println(player1.getCount());

		Player player2 = new Player("Federer");
		System.out.println(player2.getCount());

	}

}
