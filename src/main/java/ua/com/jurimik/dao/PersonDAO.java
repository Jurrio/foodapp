package ua.com.jurimik.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import ua.com.jurimik.exception.SignInException;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;

public interface PersonDAO {

	public boolean add(User person) throws FileNotFoundException, IOException;

	public User get(int id) throws FileNotFoundException, IOException, StringFormatException;

	public int login(String login, String password)
			throws FileNotFoundException, IOException, StringFormatException, SignInException;

	public boolean update(int id, User person);

	public boolean delete(User deletedPerson) throws FileNotFoundException, IOException, StringFormatException;

}
