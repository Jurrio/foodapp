package ua.com.jurimik.dao.textfile;

import ua.com.jurimik.dao.UserDAO;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;

public interface FileUserDAO extends UserDAO {

	public String convertToString(User user);

	public User convertFromString(String string) throws StringFormatException;

}
