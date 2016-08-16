package ua.com.jurimik.dao.list;

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
	public boolean add(User usr) {
		if (userList.contains(usr)) {
			LOG.info("DB exists this user already");
			return false;
		}
		usr.setId(nextId());
		LOG.info("user got id " + usr.getId());
		LOG.info("in userlist added user" + usr.getId());
		return userList.add(usr);
	}

	@Override
	public User get(int id) {
		for (User usr : userList) {
			if (usr.getId() == id) {
				return usr;
			}
		}
		return null; // TODO: replace the null exception
	}

	@Override
	public int login(String email, String password) {
		User usr = new UserBuilder().email(email).password(password).build();
		for (User u : userList) {
			if (u.equals(usr)) {
				LOG.info("get user (id " + u.getId());
				return u.getId();
			}
		}
		LOG.info("no found user with email " + email);
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
		for (User u : userList) {
			if (u.equals(deletedUser)) {
				return userList.remove(deletedUser);
			}
		}
		return false;
	}

	private static int nextId() {
		return ++id;
	}

	public List<User> getAll() {
		return userList;
	}
}
