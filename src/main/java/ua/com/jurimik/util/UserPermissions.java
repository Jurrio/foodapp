package ua.com.jurimik.util;

import java.util.HashSet;
import java.util.Set;

import ua.com.jurimik.enums.Role;

public class UserPermissions {

	private Set<Role> roles;

	public UserPermissions() {
		roles = new HashSet<Role>();
	}

	public void setChefRole(boolean isChef) {
		roles.add(Role.CHEF);
	}

	public void setAdminRole(boolean isAdmin) {
		roles.add(Role.ADMIN);
	}

	public boolean isAdmin() {
		return roles.contains(Role.ADMIN);
	}

	public boolean isChef() {
		return roles.contains(Role.CHEF);
	}

	public boolean hasRole(Role role) {
		return roles.contains(role);
	}
}
