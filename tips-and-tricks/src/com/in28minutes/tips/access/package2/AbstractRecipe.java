package com.in28minutes.tips.access.package2;

public abstract class AbstractRecipe {

	final public void execute() {
		getReady();
		doTheDish();
		cleanup();
	}

	abstract void getReady();

	abstract void doTheDish();

	abstract void cleanup();

}
