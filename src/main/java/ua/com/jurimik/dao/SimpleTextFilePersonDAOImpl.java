package ua.com.jurimik.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import ua.com.jurimik.builder.PersonBuilder;
import ua.com.jurimik.exception.SignInException;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;
import ua.com.jurimik.util.FileUtils;
import ua.com.jurimik.util.PersonUtil;

public class SimpleTextFilePersonDAOImpl implements PersonFileDAO {
	private static File storage;

	private static final Logger LOG = Logger.getLogger(SimpleTextFilePersonDAOImpl.class);

	@Override
	public boolean add(Person person) throws FileNotFoundException, IOException {
		storage = FileUtils.getFile("persons.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(storage));
		try {
			writer.write(person.toString());
			LOG.info("Add person to file. " + person.getId());
		} finally {
			writer.close();
		}
		return true; // TODO: temporary
	}

	@Override
	public Person get(int id) throws FileNotFoundException, IOException, StringFormatException {
		storage = FileUtils.getFile("persons.txt");
		BufferedReader reader = new BufferedReader(new FileReader(storage));
		LOG.info("search person with id " + id);
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				Person person = convertFromString(line);
				if (person.getId() == id) {
					LOG.info("person was found");
					reader.close();
					return person;
				}
				LOG.info("person was not found");
			}
		} finally {
			reader.close();
		}
		return null;
	}

	@Override
	public int login(String login, String password)
			throws FileNotFoundException, IOException, StringFormatException, SignInException {
		storage = FileUtils.getFile("persons.txt");
		Person usr = new PersonBuilder().email(login).password(password).build();
		Person person = null;

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		LOG.info("Login in system as " + login);
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(login) && line.contains(password)) {
					person = convertFromString(line);
					if (usr.equals(person)) {
						reader.close();
						LOG.info("login was successful");
						return person.getId();
					}
				}
			}
		} finally {
			reader.close();
		}
		LOG.info("login was unsuccessful");
		return 0;

		// throw new SignInException("You've entered an invalid email address or
		// password combination.");
	}

	@Override
	public boolean update(int id, Person person) {
		return false;
		// TODO not implemented method
	}

	@Override
	public boolean delete(Person deletedPerson) throws FileNotFoundException, IOException, StringFormatException {
		File tempFile = FileUtils.getFile("tempFile");
		storage = FileUtils.getFile("persons.txt");

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		LOG.info("delete peson " + deletedPerson.getId());
		boolean isSuccessful;
		try {
			String line;
			while ((line = reader.readLine()) != null) {

				Person person = convertFromString(line);

				if (!deletedPerson.equals(person)) {
					writer.write(line + "\n");
				} else {
					LOG.info("person was delete");
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
