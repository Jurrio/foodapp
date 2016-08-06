package ua.com.jurimik.dao.textfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.exception.SignInException;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;
import ua.com.jurimik.util.FileUtils;
import ua.com.jurimik.util.UserUtil;

public class SimpleTextFileUserDAOImpl implements FileUserDAO {
	private static File storage;

	private static final Logger LOG = Logger.getLogger(SimpleTextFileUserDAOImpl.class);

	@Override
	public boolean add(User user) throws FileNotFoundException, IOException {
		storage = FileUtils.getFile("users.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(storage));
		try {
			writer.write(user.toString());
			LOG.info("Add user to file. User-Id: " + user.getId());
		} finally {
			writer.close();
		}
		return true; // TODO: temporary
	}

	@Override
	public User get(int id) throws FileNotFoundException, IOException, StringFormatException {
		storage = FileUtils.getFile("users.txt");
		BufferedReader reader = new BufferedReader(new FileReader(storage));
		LOG.info("search users with id " + id);
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				User user = convertFromString(line);
				if (user.getId() == id) {
					LOG.info("user was found");
					reader.close();
					return user;
				}
				LOG.info("user was not found");
			}
		} finally {
			reader.close();
		}
		return null;
	}

	@Override
	public int login(String email, String password)
			throws FileNotFoundException, IOException, StringFormatException, SignInException {
		storage = FileUtils.getFile("users.txt");
		User currentUser = new UserBuilder().email(email).password(password).build();
		User user = null;

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		LOG.info("Login in system as " + email);
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(email) && line.contains(password)) {
					user = convertFromString(line);
					if (currentUser.equals(user)) {
						reader.close();
						LOG.info("login was successful");
						return user.getId();
					}
				}
			}
		} finally {
			reader.close();
		}
		LOG.info("login was unsuccessful");
		return 0;

		// throw new SignInException("You've entered an invalid email address or
		// password combination.");
	}

	@Override
	public boolean update(int id, User user) {
		return false;
		// TODO not implemented method
	}

	@Override
	public boolean delete(User deletedUser) throws FileNotFoundException, IOException, StringFormatException {
		File tempFile = FileUtils.getFile("tempFile");
		storage = FileUtils.getFile("users.txt");

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		LOG.info("delete user " + deletedUser.getId());
		boolean isSuccessful;
		try {
			String line;
			while ((line = reader.readLine()) != null) {

				User user = convertFromString(line);

				if (!deletedUser.equals(user)) {
					writer.write(line + "\n");
				} else {
					LOG.info("user was deleted");
				}
			}
			isSuccessful = tempFile.renameTo(storage);
		} finally {
			reader.close();
			writer.close();
		}

		return isSuccessful;
	}

	@Override
	public String convertToString(User user) {
		return user.toString();
	}

	@Override
	public User convertFromString(String string) throws StringFormatException {
		return UserUtil.valueOfSimpleString(string);
	}

}
