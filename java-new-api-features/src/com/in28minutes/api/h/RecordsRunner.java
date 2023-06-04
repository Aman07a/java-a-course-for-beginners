package com.in28minutes.api.h;

import java.util.Objects;

class Person {
	private final String name;
	private final String email;
	private final String phoneNumber;

	public Person(String name, String email, String phoneNumber) {
		if (name == null) {
			throw new IllegalArgumentException("name is null");
		}
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String name() {
		System.out.println("Do Something");
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Person person = (Person) obj;
		return Objects.equals(name, person.name) && Objects.equals(email, person.email)
				&& Objects.equals(phoneNumber, person.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, email, phoneNumber);
	}
}

public class RecordsRunner {

	public static void main(String[] args) {

		Person person = new Person("Ranga", "ranga@in28minutes.com", "123-456-7890");
		System.out.println(person.name());

		Person person1 = new Person("Ranga", "ranga@in28minutes.com", "123-456-7890");
		Person person2 = new Person("Ranga1", "ranga@in28minutes.com", "123-456-7890");
		System.out.println(person.equals(person1));
		System.out.println(person.equals(person2));

    }

}
