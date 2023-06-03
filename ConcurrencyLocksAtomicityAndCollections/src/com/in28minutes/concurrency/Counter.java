package com.in28minutes.concurrency;

public class Counter {
	int i;

	synchronized public void increment() {
		i++;
		// get i
		// increment
		// set i
	}

	public int getI() {
		return i;
	}
}
