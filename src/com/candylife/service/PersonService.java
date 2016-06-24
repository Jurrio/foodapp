package com.candylife.service;

import com.candylife.dao.PersonRepository;
import com.candylife.model.Person;

public class PersonService {

	public static boolean add(Person person) {
		return PersonRepository.add(person);
	}

}
