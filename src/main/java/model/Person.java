package main.java.model;

public class Person {

	private User user;
	private String firstName;
	private String lastName;

	public Person() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(int id) {
		this.user.setId(id);
	}

	public int getId() {
		return user.getId();
	}
}
