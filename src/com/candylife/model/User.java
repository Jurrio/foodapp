package com.candylife.model;

public class User {

	private int id;
	private String email;
	private String password;
	private boolean isChef;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isChef() {
		return isChef;
	}

	public void setChef(boolean isChef) {
		this.isChef = isChef;
	}

	@Override
	public int hashCode() {
		return 31 * email.hashCode() + 7 * password.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (!this.getEmail().equals(other.getEmail()))
			return false;
		if (!this.getPassword().equals(other.getPassword()))
			return false;
		return true;
	}

}
