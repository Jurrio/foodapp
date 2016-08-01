package ua.com.jurimik.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import ua.com.jurimik.exception.SignInException;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;

public interface UserDAO {

	public boolean add(User user) throws FileNotFoundException, IOException;

	public User get(int id) throws FileNotFoundException, IOException, StringFormatException;

	public int login(String login, String password)
			throws FileNotFoundException, IOException, StringFormatException, SignInException;

	public boolean update(int id, User user);

	public boolean delete(User deletedUser) throws FileNotFoundException, IOException, StringFormatException;

}
