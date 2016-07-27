package ua.com.jurimik.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import ua.com.jurimik.exception.SignInException;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;

public interface PersonDAO {

	public boolean add(Person person) throws FileNotFoundException, IOException;

	public Person get(int id) throws FileNotFoundException, IOException, StringFormatException;

	public int login(String login, String password)
			throws FileNotFoundException, IOException, StringFormatException, SignInException;

	public boolean update(int id, Person person);

	public boolean delete(Person deletedPerson) throws FileNotFoundException, IOException, StringFormatException;

}
