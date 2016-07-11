package ua.com.jurimik.util;

import ua.com.jurimik.builder.PersonBuilder;
import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;
import ua.com.jurimik.model.User;

public class PersonUtil {

	public static Person valueOfSimpleString(String simpleString) throws StringFormatException {
		if (!checkSimpleStringWithRegex(simpleString)) {
			throw new StringFormatException("Bad string");
		}
		String[] params = simpleString.split("#");
		int id = Integer.parseInt(params[2]);
		boolean isChef = Boolean.parseBoolean(params[5]);
		User usr = new UserBuilder(params[3], params[4]).id(id).chef(isChef).build();
		Person pers = new PersonBuilder().firstName(params[0]).lastName(params[1]).user(usr).build();
		return pers;

	}

	private static boolean checkSimpleStringWithRegex(String simpleString) {
		// not implemented
		return true;
	}

	public static String parseToCsv(Person person) {
		StringBuilder sb = new StringBuilder();
		sb.append(person.getId()).append(",").append(person.getFirstName()).append(",").append(person.getLastName())
				.append(",").append(person.getUser().getEmail()).append(",").append(person.getUser().getPassword())
				.append(",");
		return sb.toString();
	}

}
