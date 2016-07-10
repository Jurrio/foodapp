package main.java.util;

import main.java.builder.PersonBuilder;
import main.java.builder.UserBuilder;
import main.java.exception.StringFormatException;
import main.java.model.Person;
import main.java.model.User;

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
		//not implemented
		return true;
	}

}
