package ua.com.jurimik.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;
import ua.com.jurimik.model.User;
import ua.com.jurimik.util.FileUtils;
import ua.com.jurimik.util.PersonUtil;

public class CsvPersonFileDAOImpl implements AbstractPersonFileDAO {

	private File storage;

	@Override
	public boolean add(Person person) throws IOException {
		storage = FileUtils.getFile("persons.csv");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(storage);
			fos.write(convertToString(person).getBytes());
		} finally {
			fos.close();
		}
		return false;
	}

	@Override
	public Person get(int id) throws IOException, StringFormatException {
		storage = FileUtils.getFile("persons.csv");
		FileInputStream fis = null;
		Person person = null;
		try {
			fis = new FileInputStream(storage);
			int data = fis.read();
			char c;
			StringBuilder sb = new StringBuilder();
			while (data != -1) {
				c = (char) data;
				sb.append(c);
				if (c == '\n') {
					person = convertFromString(sb.toString());
					if (person.getId() == id) {
						fis.close();
						return person;
					}
					sb = new StringBuilder();
				}
				data = fis.read();
			}
		} finally {
			fis.close();
		}
		return null;
	}

	@Override
	public boolean login(String login, String password) throws IOException, StringFormatException {
		storage = FileUtils.getFile("persons.csv");
		User usr = new UserBuilder(login, password).build();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(storage);
			int data = fis.read();
			char c;
			StringBuilder sb = new StringBuilder();
			while (data != -1) {
				c = (char) data;
				sb.append(c);
				if (c == '\n') {
					Person person = convertFromString(sb.toString());
					if (usr.equals(person.getUser())) {
						fis.close();
						return true;
					}
					sb = new StringBuilder();
				}
				data = fis.read();
			}
		} finally {
			fis.close();
		}
		return false;
	}

	@Override
	public boolean update(int id, Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person deletedPerson) throws IOException, StringFormatException {
		storage = FileUtils.getFile("persons.csv");
		File tempFile = FileUtils.getFile("tempfile.csv");

		FileOutputStream fos = null;
		FileInputStream fis = null;
		boolean isSuccessful;
		try {
			fos = new FileOutputStream(tempFile);
			fis = new FileInputStream(storage);
			int data = fis.read();
			char c;
			StringBuilder sb = new StringBuilder();
			while (data != -1) {
				c = (char) data;
				sb.append(c);
				if (c == '\n') {
					Person person = convertFromString(sb.toString());
					if (!deletedPerson.getUser().equals(person.getUser())) {
						fos.write(sb.toString().getBytes());
						sb = new StringBuilder();
					}
				}
				data = fis.read();
			}
			isSuccessful = tempFile.renameTo(storage);
		} finally {
			fis.close();
			fos.close();
		}
		return isSuccessful;
	}

	@Override
	public String convertToString(Person person) {
		return PersonUtil.parseToCsv(person);
	}

	@Override
	public Person convertFromString(String string) throws StringFormatException {
		return PersonUtil.valueOfCsv(string);
	}

}
