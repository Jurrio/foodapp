package ua.com.jurimik.model;

import ua.com.jurimik.util.UserPermissions;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserPermissions permissions;

	public User() {
		permissions = new UserPermissions();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return permissions.isChef();
	}

	public void setChef(boolean isChef) {
		this.permissions.setChefRole(isChef);
	}

	public boolean isAdmin() {
		return permissions.isAdmin();
	}

	public void setAdmin(boolean isAdmin) {
		this.permissions.setAdminRole(isAdmin);
	}
	
	public UserPermissions getPermissions() {
		return permissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(" ").append(firstName).append(" ").append(lastName).append(" ")
				.append(email).append(" ");
		if (isChef()) {
			sb.append("User is chef ");
		}
		if (isAdmin()) {
			sb.append("User is admin");
		}
		return sb.toString();
	}

}
