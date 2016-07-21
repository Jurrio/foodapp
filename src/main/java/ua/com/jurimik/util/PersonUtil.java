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
		boolean isAdmin = Boolean.parseBoolean(params[6]);
		User usr = new UserBuilder(params[3], params[4]).id(id).chef(isChef).admin(isAdmin).build();
		Person pers = new PersonBuilder().firstName(params[0]).lastName(params[1]).user(usr).build();
		return pers;

	}

	public static String parseToCsv(Person person) {
		StringBuilder sb = new StringBuilder();
		sb.append(person.getId()).append(",").append(person.getFirstName()).append(",").append(person.getLastName())
				.append(",").append(person.getUser().getEmail()).append(",").append(person.getUser().getPassword())
				.append(",").append(person.getUser().isChef()).append(",").append(person.getUser().isAdmin());
		return sb.toString();
	}

	public static Person valueOfCsv(String csvString) throws StringFormatException {
		if (!checkCsvStringWithRegex(csvString)) {
			throw new StringFormatException("Bad CSV string");
		}
		String[] params = csvString.split(",");
		int id = Integer.parseInt(params[0]);
		boolean isChef = Boolean.parseBoolean(params[5]);
		boolean isAdmin = Boolean.parseBoolean(params[6]);
		User usr = new UserBuilder(params[3], params[4]).id(id).chef(isChef).admin(isAdmin).build();
		Person person = new PersonBuilder().firstName(params[1]).lastName(params[2]).user(usr).build();
		return person;
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
