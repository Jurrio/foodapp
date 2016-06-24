package com.candylife.model;

public class User {

	private int id;
	private String email;
	private String password;
	private boolean isCook;

	public User(String email, String password, boolean isCook) {
		this.email = email;
		this.password = password;
		this.isCook = isCook;
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

	public boolean isCook() {
		return isCook;
	}

	public void setCook(boolean isCook) {
		this.isCook = isCook;
	}

}
