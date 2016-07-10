package main.java.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.java.exception.SignInException;
import main.java.exception.StringFormatException;
import main.java.model.Person;

public interface AbstractPersonDAO {
	
	public boolean add(Person person) throws FileNotFoundException, IOException;
	public Person get(int id) throws FileNotFoundException, IOException, StringFormatException;
	public Person login(String login, String password) throws FileNotFoundException, IOException, StringFormatException, SignInException;
	public boolean update(int id, Person person);
	public boolean delete(Person deletedPerson) throws FileNotFoundException, IOException, StringFormatException;
	
	
}
