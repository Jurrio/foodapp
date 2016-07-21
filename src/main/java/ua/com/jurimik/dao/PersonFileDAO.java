package ua.com.jurimik.dao;

import ua.com.jurimik.dao.PersonDAO;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;

public interface PersonFileDAO extends PersonDAO {

	public String convertToString(Person person);

	public Person convertFromString(String string) throws StringFormatException;

}
