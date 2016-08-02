package ua.com.jurimik.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.model.User;
import ua.com.jurimik.util.FileUtils;
import ua.com.jurimik.util.UserUtil;

public class CsvFileUserDAOImpl implements FileUserDAO {

	private static final Logger LOG = Logger.getLogger(CsvFileUserDAOImpl.class);
	
	private File storage;

	@Override
	public boolean add(User user) throws IOException {
		storage = FileUtils.getFile("users.csv");
		FileOutputStream fos = null;
		LOG.info("Add user to file " + user.getId());
		try {
			fos = new FileOutputStream(storage);
			fos.write(convertToString(user).getBytes());
		} finally {
			fos.close();
		}
		return true; //TODO: temporary
	}

	@Override
	public User get(int id) throws IOException, StringFormatException {
		storage = FileUtils.getFile("users.csv");
		FileInputStream fis = null;
		User user = null;
		LOG.info("get user with id " + id);
		try {
			fis = new FileInputStream(storage);
			int data = fis.read();
			char c;
			StringBuilder sb = new StringBuilder();
			while (data != -1) {
				c = (char) data;
				sb.append(c);
				if (c == '\n') {
					user = convertFromString(sb.toString());
					if (user.getId() == id) {
						LOG.info("user was found");
						fis.close();
						return user;
					}
					sb = new StringBuilder();
				}
				data = fis.read();
			}
		} finally {
			fis.close();
		}
		LOG.info("user was not found");
		return null;
	}

	@Override
	public int login(String email, String password) throws IOException, StringFormatException {
		storage = FileUtils.getFile("users.csv");
		User currentUser = new UserBuilder().email(email).password(password).build();
		FileInputStream fis = null;
		LOG.info("Login in system as " + email);
		try {
			fis = new FileInputStream(storage);
			int data = fis.read();
			char c;
			StringBuilder sb = new StringBuilder();
			while (data != -1) {
				c = (char) data;
				sb.append(c);
				if (c == '\n') {
					User user = convertFromString(sb.toString());
					if (currentUser.equals(user)) {
						LOG.info("login was successful");
						fis.close();
						return user.getId();
					}
					sb = new StringBuilder();
				}
				data = fis.read();
			}
		} finally {
			fis.close();
		}
		LOG.info("login was unsuccessful");
		return 0;
	}

	@Override
	public boolean update(int id, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User deletedUser) throws IOException, StringFormatException {
		storage = FileUtils.getFile("users.csv");
		File tempFile = FileUtils.getFile("tempfile.csv");

		FileOutputStream fos = null;
		FileInputStream fis = null;
		boolean isSuccessful;
		LOG.info("delete user " + deletedUser.getId());
		try {
			fos = new FileOutputStream(tempFile);
			fis = new FileInputStream(storage);
			int data = fis.read();
			char c;
			StringBuilder sb = new StringBuilder();
			while (data != -1) {
				c = (char) data;
				sb.append(c);
				if (c == '\n') {
					User user = convertFromString(sb.toString());
					if (!deletedUser.equals(user)) {
						fos.write(sb.toString().getBytes());
						sb = new StringBuilder();
					} else {
						LOG.info("user was delete");
					}
				}
				data = fis.read();
			}
			isSuccessful = tempFile.renameTo(storage);
		} finally {
			fis.close();
			fos.close();
		}
		return isSuccessful;
	}

	@Override
	public String convertToString(User user) {
		return UserUtil.parseToCsv(user);
	}

	@Override
	public User convertFromString(String string) throws StringFormatException {
		return UserUtil.valueOfCsv(string);
	}

}
