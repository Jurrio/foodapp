package ua.com.jurimik.model;

import ua.com.jurimik.builder.PersonBuilder;
import ua.com.jurimik.builder.UserBuilder;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName).append("#").append(lastName).append("#").append(user.getId()).append("#")
				.append(user.getEmail()).append("#").append(user.getPassword()).append("#").append(user.isChef())
				.append(user.isAdmin());
		return sb.toString();
	}

	public static void main(String[] args) {
		User usr = new UserBuilder("alice@hotmail.com", "uyeaj%5").id(5).chef(false).build();
		Person person = new PersonBuilder().firstName("Alice").lastName("Johnson").user(usr).build();
		System.out.println(person.toString());
	}
}
