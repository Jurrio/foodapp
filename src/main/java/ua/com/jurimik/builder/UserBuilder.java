package ua.com.jurimik.builder;

import ua.com.jurimik.model.User;

public class UserBuilder {

	private final String email;
	private final String password;
	private boolean isChef;
	private int id;

	public UserBuilder(String email, String password) {
		this.email = email;
		this.password = password;
		this.isChef = false;
		this.id = 0;
	}

	public UserBuilder chef(boolean isChef) {
		this.isChef = isChef;
		return this;
	}

	public UserBuilder id(int id) {
		this.id = id;
		return this;
	}

	public User build() {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setChef(isChef);
		user.setId(id);
		return user;
	}
}
