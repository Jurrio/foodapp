package ua.com.jurimik.dao;

import ua.com.jurimik.dao.PersonDAO;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;

public interface PersonFileDAO extends PersonDAO {

	public String convertToString(User person);

	public User convertFromString(String string) throws StringFormatException;

}
