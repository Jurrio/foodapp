package ua.com.jurimik.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.model.User;

public class ListUserDAOImpl implements ListUserDAO {

	private static List<User> userList = new ArrayList<>();
	private static int id = 0;

	private static final Logger LOG = LogManager.getLogger(ListUserDAOImpl.class);

	@Override
	public boolean add(User user) {
		if (userList.contains(user)) {
			LOG.info("DB exists this user already");
			return false;
		}
		user.setId(nextId());
		LOG.info("user got id " + user.getId());
		LOG.info("in userlist added user" + user.getId());
		return userList.add(user);
	}

	@Override
	public User get(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null; // TODO: replace the null exception
	}

	@Override
	public int login(String login, String password) {
		User usr = new UserBuilder().email(login).password(password).build();
		for (User p : userList) {
			if (p.equals(usr)) {
				LOG.info("get user (id " + p.getId());
				return p.getId();
			}
		}
		LOG.info("no found user with email " + login + " and password " + password);
		return 0;
	}

	@Override
	public boolean update(int id, User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				userList.set(i, user);
				break;
			}
		}
		return userList.contains(user);
	}

	@Override
	public boolean delete(User deletedUser) {
		for (User p : userList) {
			if (p.equals(deletedUser)) {
				return userList.remove(deletedUser);
			}
		}
		return false;
	}

	private static int nextId() {
		return ++id;
	}
}
