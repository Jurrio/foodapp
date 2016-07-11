package ua.com.jurimik.dao;

import ua.com.jurimik.dao.AbstractPersonDAO;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.Person;

public interface AbstractPersonFileDAO extends AbstractPersonDAO {

	public String convertToString(Person person);

	public Person convertFromString(String string) throws StringFormatException;

}
