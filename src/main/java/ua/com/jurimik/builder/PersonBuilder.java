package ua.com.jurimik.builder;

import ua.com.jurimik.model.Person;

public class PersonBuilder {

	private String email;
	private String password;
	private int id;
	private boolean isChef;
	private boolean isAdmin;
	private String firstName;
	private String lastName;

	public PersonBuilder() {
	}

	public PersonBuilder password(String password) {
		this.password = password;
		return this;
	}

	public PersonBuilder email(String email) {
		this.email = email;
		return this;
	}

	public PersonBuilder id(int id) {
		this.id = id;
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

	public PersonBuilder chef(boolean isChef) {
		this.isChef = isChef;
		return this;
	}

	public PersonBuilder admin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	public Person build() {
		Person person = new Person();
		person.setEmail(email);
		person.setPassword(password);
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setChef(isChef);
		person.setAdmin(isAdmin);
		return person;
	}

}
