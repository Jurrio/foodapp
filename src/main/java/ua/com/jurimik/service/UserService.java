package ua.com.jurimik.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.dao.ListUserDAOImpl;
import ua.com.jurimik.model.User;

public class UserService {

	private static final Logger LOG = LogManager.getLogger(UserService.class);

	public boolean add(User user) {
		LOG.info("Call to UserDao.add");
		return new ListUserDAOImpl().add(user);
	}

	public int login(String login, String password) {
		LOG.info("Call to UserDAO.login with login " + login);
		return new ListUserDAOImpl().login(login, password);
	}

	public User get(int id) {
		LOG.info("Call to UserDAO.get with id " + id);
		return new ListUserDAOImpl().get(id);
	}

	public User get(String login, String password) {
		LOG.info("Call to UserDAO.get with login " + login);
		return new ListUserDAOImpl().get(login(login, password));
	}

}