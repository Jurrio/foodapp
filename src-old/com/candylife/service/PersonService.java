package com.candylife.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.candylife.dao.PersonRepository;
import com.candylife.model.Person;

public class PersonService {

	private static final Logger LOG = LogManager.getLogger(PersonService.class.getName());

	public static boolean add(Person person) {
		LOG.info("Call to PersonRepository.add");
		return PersonRepository.add(person);
	}

	public static boolean get(String login, String password) {
		LOG.info("Call to PersonRepository.get with login " + login + " and password " + password);
		return PersonRepository.get(login, password);
	}

}
