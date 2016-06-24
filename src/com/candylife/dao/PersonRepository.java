package com.candylife.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.candylife.model.Person;

public class PersonRepository {

	private static List<Person> personList = new ArrayList<>();
	private static int id = 0;

	private static final Logger LOG = LogManager.getLogger(PersonRepository.class.getName());

	public static boolean add(Person person) {
		if (personList.contains(person)) {
			LOG.info("DB exists this meal already");
			return false;
		}
		person.setId(nextId());
		LOG.info("meal got id " + person.getId());
		LOG.info("in meallist added meal " + person.getId());
		return personList.add(person);
	}

	private static int nextId() {
		return ++id;
	}

}
