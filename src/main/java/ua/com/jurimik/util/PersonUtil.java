package ua.com.jurimik.util;

import ua.com.jurimik.builder.PersonBuilder;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;

public class PersonUtil {

	public static String createSimpleString(Person person) {
		StringBuilder sbld = new StringBuilder();
		sbld.append(person.getId()).append("#")
			.append(person.getFirstName()).append("#")
			.append(person.getLastName()).append("#")
			.append(person.getEmail()).append("#")
			.append(person.getPassword()).append("#")
			.append(person.isChef()).append("#")
			.append(person.isAdmin());
		return sbld.toString();
	}

	public static Person valueOfSimpleString(String simpleString) throws StringFormatException {
		if (!checkSimpleStringWithRegex(simpleString)) {
			throw new StringFormatException("Bad string");
		}
		String[] params = simpleString.split("#");
		int id = Integer.parseInt(params[0]);
		boolean isChef = Boolean.parseBoolean(params[5]);
		boolean isAdmin = Boolean.parseBoolean(params[6]);
		Person pers = new PersonBuilder().firstName(params[1]).lastName(params[2]).email(params[3]).password(params[4])
				.id(id).chef(isChef).admin(isAdmin).build();
		return pers;

	}

	public static String parseToCsv(Person person) {
		StringBuilder sbld = new StringBuilder();
		sbld.append(person.getId()).append(",")
			.append(person.getFirstName()).append(",")
			.append(person.getLastName()).append(",")
			.append(person.getEmail()).append(",")
			.append(person.getPassword()).append(",")
			.append(person.isChef()).append(",")
			.append(person.isAdmin());
		return sbld.toString();
	}

	public static Person valueOfCsv(String csvString) throws StringFormatException {
		if (!checkCsvStringWithRegex(csvString)) {
			throw new StringFormatException("Bad CSV string");
		}
		String[] params = csvString.split(",");
		int id = Integer.parseInt(params[0]);
		boolean isChef = Boolean.parseBoolean(params[5]);
		boolean isAdmin = Boolean.parseBoolean(params[6]);
		Person person = new PersonBuilder().id(id).firstName(params[1]).lastName(params[2]).email(params[3])
				.password(params[4]).chef(isChef).admin(isAdmin).build();
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
