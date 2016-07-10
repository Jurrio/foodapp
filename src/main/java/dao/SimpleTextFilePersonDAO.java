package main.java.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.builder.UserBuilder;
import main.java.exception.SignInException;
import main.java.exception.StringFormatException;
import main.java.model.Person;
import main.java.model.User;
import main.java.util.FileUtils;
import main.java.util.PersonUtil;

public class SimpleTextFilePersonDAO implements AbstractPersonFileDAO {
	private static File storage;

	@Override
	public boolean add(Person person) throws FileNotFoundException, IOException {
		storage = FileUtils.getFile("persons.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(storage));
		try {
			writer.write(person.toString());
		} finally {
			writer.close();
		}
		return true; //TODO: temporary
	}

	@Override
	public boolean login(String login, String password)
			throws FileNotFoundException, IOException, StringFormatException, SignInException {
		User usr = new UserBuilder(login, password).build();
		Person person = null;

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(login) && line.contains(password)) {
					person = convertFromString(line);
					if (usr.equals(person.getUser())) {
						reader.close();
						return true;
					}
				}
			}
		} finally {
			reader.close();
		}
		return false;

//		throw new SignInException("You've entered an invalid email address / password combination.");
	}

	@Override
	public Person get(int id) throws FileNotFoundException, IOException, StringFormatException {
		BufferedReader reader = new BufferedReader(new FileReader(storage));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				Person person = convertFromString(line);
				if (person.getId() == id) {
					reader.close();
					return person;
				}
			}
		} finally {
			reader.close();
		}
		return null;
	}

	@Override
	public boolean update(int id, Person person) {
		return false;
		// TODO not implemented method
	}

	@Override
	public boolean delete(Person deletedPerson) throws FileNotFoundException, IOException, StringFormatException {
		File tempFile = FileUtils.getFile("tempFile");

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		boolean isSuccessful;
		try {
			String line;
			while ((line = reader.readLine()) != null) {

				Person person = convertFromString(line);

				if (!deletedPerson.getUser().equals(person.getUser())) {
					writer.write(line + "\n");
				}
			}
			isSuccessful = tempFile.renameTo(storage);
		} finally {
			reader.close();
			writer.close();
		}

		return isSuccessful;
	}

	@Override
	public String convertToString(Person person) {
		return person.toString();
	}

	@Override
	public Person convertFromString(String string) throws StringFormatException {
		return PersonUtil.valueOfSimpleString(string);
	}

}
