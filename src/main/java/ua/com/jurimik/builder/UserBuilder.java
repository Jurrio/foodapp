package ua.com.jurimik.builder;

import ua.com.jurimik.model.User;

public class UserBuilder {

	private final String email;
	private final String password;
	private boolean isChef;
	private boolean isAdmin;
	private int id;

	public UserBuilder(String email, String password) {
		this.email = email;
		this.password = password;
		this.isChef = false;
		this.isAdmin = false;
		this.id = 0;
	}

	public UserBuilder chef(boolean isChef) {
		this.isChef = isChef;
		return this;
	}
	
	public UserBuilder admin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
		user.setAdmin(isAdmin);
		user.setId(id);
		return user;
	}
}
