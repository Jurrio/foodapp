package ua.com.jurimik.constant;

import java.util.HashMap;

import ua.com.jurimik.enums.Role;

public class UrlPermissions {
	private static HashMap<String, Role> rules = new HashMap<>();
	static {
		rules.put("add.jsp", Role.CHEF);
		rules.put("dashboard.jsp", Role.CHEF);
		rules.put("structure.jsp", Role.ADMIN);
	}
	
	public static HashMap<String, Role> getRules() {
		return rules;
	}
}
