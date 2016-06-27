package main.java.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.java.dao.PersonRepository;
import main.java.model.Person;

public class PersonService {

	private static final Logger LOG = LogManager.getLogger(PersonService.class);

	public static boolean add(Person person) {
		LOG.info("Call to PersonRepository.add");
		return PersonRepository.add(person);
	}

	public static boolean get(String login, String password) {
		LOG.info("Call to PersonRepository.get with login " + login + " and password " + password);
		return PersonRepository.get(login, password);
	}

}
