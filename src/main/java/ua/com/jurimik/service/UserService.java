package ua.com.jurimik.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.dao.ListUserDAOImpl;
import ua.com.jurimik.model.User;

public class UserService {

	private static final Logger LOG = LogManager.getLogger(UserService.class);

	public boolean add(User user) {
		LOG.info("Call to UserDAO.add");
		return new ListUserDAOImpl().add(user);
	}

	public int login(String email, String password) {
		LOG.info("Call to UserDAO.login with login " + email);
		return new ListUserDAOImpl().login(email, password);
	}

	public User get(int id) {
		LOG.info("Call to UserDAO.get with id " + id);
		return new ListUserDAOImpl().get(id);
	}

	public User get(String email, String password) {
		LOG.info("Call to UserDAO.get with login " + email);
		return new ListUserDAOImpl().get(login(email, password));
	}
	
	public static void main(String[] args) {
		UserService service = new UserService();
		service.add(new UserBuilder().email("asas").firstName("asda").lastName("asa").build());
		User user = service.get(1);
		System.out.println(user);
	}

}