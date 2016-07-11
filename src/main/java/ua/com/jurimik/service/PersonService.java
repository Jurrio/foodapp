package ua.com.jurimik.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.dao.ListPersonDAO;
import ua.com.jurimik.model.Person;

public class PersonService {

	private static final Logger LOG = LogManager.getLogger(PersonService.class);

	public static boolean add(Person person) {
		LOG.info("Call to PersonRepository.add");
		return new ListPersonDAO().add(person);
	}

	public static boolean login(String login, String password) {
		LOG.info("Call to PersonRepository.get with login " + login + " and password " + password);
		return new ListPersonDAO().login(login, password);
	}

}
