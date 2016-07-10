package main.java.dao;

import main.java.exception.StringFormatException;
import main.java.model.Person;

public interface AbstractPersonFileDAO extends AbstractPersonDAO {
	
	public String convertToString(Person person);
	public Person convertFromString(String string) throws StringFormatException;
	
}
