package ua.com.jurimik.util;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;

public class UserUtil {

	public static String createSimpleString(User user) {
		StringBuilder sbld = new StringBuilder();
		sbld.append(user.getId()).append("#")
			.append(user.getFirstName()).append("#")
			.append(user.getLastName()).append("#")
			.append(user.getEmail()).append("#")
			.append(user.getPassword()).append("#")
			.append(user.isChef()).append("#")
			.append(user.isAdmin());
		return sbld.toString();
	}

	public static User valueOfSimpleString(String simpleString) throws StringFormatException {
		if (!checkSimpleStringWithRegex(simpleString)) {
			throw new StringFormatException("Bad string");
		}
		String[] params = simpleString.split("#");
		int id = Integer.parseInt(params[0]);
		boolean isChef = Boolean.parseBoolean(params[5]);
		boolean isAdmin = Boolean.parseBoolean(params[6]);
		User usr = new UserBuilder().firstName(params[1]).lastName(params[2]).email(params[3]).password(params[4])
				.id(id).chef(isChef).admin(isAdmin).build();
		return usr;

	}

	public static String parseToCsv(User user) {
		StringBuilder sbld = new StringBuilder();
		sbld.append(user.getId()).append(",")
			.append(user.getFirstName()).append(",")
			.append(user.getLastName()).append(",")
			.append(user.getEmail()).append(",")
			.append(user.getPassword()).append(",")
			.append(user.isChef()).append(",")
			.append(user.isAdmin());
		return sbld.toString();
	}

	public static User valueOfCsv(String csvString) throws StringFormatException {
		if (!checkCsvStringWithRegex(csvString)) {
			throw new StringFormatException("Bad CSV string");
		}
		String[] params = csvString.split(",");
		int id = Integer.parseInt(params[0]);
		boolean isChef = Boolean.parseBoolean(params[5]);
		boolean isAdmin = Boolean.parseBoolean(params[6]);
		User user = new UserBuilder().id(id).firstName(params[1]).lastName(params[2]).email(params[3])
				.password(params[4]).chef(isChef).admin(isAdmin).build();
		return user;
	}

	private static boolean checkCsvStringWithRegex(String csvString) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkSimpleStringWithRegex(String simpleString) {
		// not implemented
		return true;
	}

}
