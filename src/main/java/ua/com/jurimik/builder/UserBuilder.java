package ua.com.jurimik.builder;

import ua.com.jurimik.model.User;

public class UserBuilder {

	private String email;
	private String password;
	private int id;
	private boolean isChef;
	private boolean isAdmin;
	private String firstName;
	private String lastName;

	public UserBuilder() {
	}

	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder email(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder id(int id) {
		this.id = id;
		return this;
	}

	public UserBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserBuilder chef(boolean isChef) {
		this.isChef = isChef;
		return this;
	}

	public UserBuilder admin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	public User build() {
		User person = new User();
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
