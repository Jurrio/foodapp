package main.java.builder;

import main.java.model.User;

public class UserBuilder {

	private final String email;
	private final String password;
	private boolean isChef;

	public UserBuilder(String email, String password) {
		this.email = email;
		this.password = password;
		this.isChef = false;
	}

	public UserBuilder chef(boolean isChef) {
		this.isChef = isChef;
		return this;
	}

	public User build() {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setChef(isChef);
		return user;
	}
}
