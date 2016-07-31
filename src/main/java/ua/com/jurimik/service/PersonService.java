package ua.com.jurimik.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.dao.ListPersonDAOImpl;
import ua.com.jurimik.model.User;

public class PersonService {

	private static final Logger LOG = LogManager.getLogger(PersonService.class);

	public boolean add(User person) {
		LOG.info("Call to PersonRepository.add");
		return new ListPersonDAOImpl().add(person);
	}

	public int login(String login, String password) {
		LOG.info("Call to PersonRepository.login with login " + login + " and password " + password);
		return new ListPersonDAOImpl().login(login, password);
	}

	public User get(int id) {
		LOG.info("Call to PersonRepository.get with id " + id);
		return new ListPersonDAOImpl().get(id);
	}

	public User get(String login, String password) {
		LOG.info("Call to PersonRepository.get with login " + login + " and password " + password);
		return new ListPersonDAOImpl().get(login(login, password));
	}

}