package com.in28minutes.tips.access.package1;

final class FinalClass {

}

//class SomeClass extends FinalClase {
//}

class SomeClass {
	final public void doSomething() {
	}

	public void doSomthingElse(final int arg) {
		// arg = 6;
	}
}

class ExtendingClass extends SomeClass {
	// public void doSomthing() {
	// }
}

public class FinalNonAccessModifierRunner {

	public static void main(String[] args) {

		final int i;
		i = 5;

		// i = 7;

	}

}
