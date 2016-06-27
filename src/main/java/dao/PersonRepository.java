package main.java.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.java.builder.UserBuilder;
import main.java.model.Person;
import main.java.model.User;

public class PersonRepository {

	private static List<Person> personList = new ArrayList<>();
	private static int id = 0;

	private static final Logger LOG = LogManager.getLogger(PersonRepository.class);

	public static boolean add(Person person) {
		if (personList.contains(person)) {
			LOG.info("DB exists this meal already");
			return false;
		}
		person.setId(nextId());
		LOG.info("person got id " + person.getId());
		LOG.info("in personlist added person" + person.getId());
		return personList.add(person);
	}
	
	public static boolean get(String login, String password) {
		User usr = new UserBuilder(login, password).build();
		for(Person p : personList) {
			if (p.getUser().equals(usr)) {
				LOG.info("get person (id " + p.getId());
				return true;
			}
		}
		LOG.info("no found user with email " + login + " and password " + password);
		return false;
	}

	private static int nextId() {
		return ++id;
	}

}
