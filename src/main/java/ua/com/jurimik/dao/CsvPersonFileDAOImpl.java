package ua.com.jurimik.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;
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
				data = fis.read();
				if (c == '\n') {
					person = convertFromString(sb.toString());
					if (person.getId() == id) {
						fis.close();
						return person;
					}
					sb = new StringBuilder();
				}
			}
		} finally {
			fis.close();
		}
		return null;
	}

	@Override
	public boolean login(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person deletedPerson) {
		// TODO Auto-generated method stub
		return false;
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
