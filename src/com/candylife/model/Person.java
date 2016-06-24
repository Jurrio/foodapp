package com.candylife.model;

public class Person {

	private User user;
	private String name;

	public Person(User user, String name) {
		this.user = user;
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
