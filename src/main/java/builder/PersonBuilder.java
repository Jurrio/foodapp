package main.java.builder;

import main.java.model.Person;
import main.java.model.User;

public class PersonBuilder {

	private User user;
	private String firstName;
	private String lastName;

	public PersonBuilder() {
	}

	public PersonBuilder user(User user) {
		this.user = user;
		return this;
	}

	public PersonBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Person build() {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setUser(user);
		return person;
	}

}
