package ua.com.jurimik.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.model.Person;
import ua.com.jurimik.model.User;

public class ListPersonDAOImpl implements PersonListDAO {

	private static List<Person> personList = new ArrayList<>();
	private static int id = 0;

	private static final Logger LOG = LogManager.getLogger(ListPersonDAOImpl.class);

	@Override
	public boolean add(Person person) {
		if (personList.contains(person)) {
			LOG.info("DB exists this person already");
			return false;
		}
		person.setId(nextId());
		LOG.info("person got id " + person.getId());
		LOG.info("in personlist added person" + person.getId());
		return personList.add(person);
	}

	@Override
	public Person get(int id) {
		for (Person person : personList) {
			if (person.getId() == id) {
				return person;
			}
		}
		return null; // TODO: replace the null exception
	}

	@Override
	public boolean login(String login, String password) {
		User usr = new UserBuilder(login, password).build();
		for (Person p : personList) {
			if (p.getUser().equals(usr)) {
				LOG.info("get person (id " + p.getId());
				return true;
			}
		}
		LOG.info("no found user with email " + login + " and password " + password);
		return false;
	}

	@Override
	public boolean update(int id, Person person) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getId() == id) {
				personList.set(i, person);
				break;
			}
		}
		return personList.contains(person);
	}

	@Override
	public boolean delete(Person deletedPerson) {
		for (Person p : personList) {
			if (p.getUser().equals(deletedPerson.getUser())) {
				return personList.remove(deletedPerson);
			}
		}
		return false;
	}

	@Deprecated
	public boolean updatePassword(Person person, String login, String oldPassword, String newPassword) {
		User usr = new UserBuilder(login, oldPassword).build();
		if (person.getUser().equals(usr)) {
			usr.setPassword(newPassword);
			LOG.info("password changed for person (id " + person.getId());
			return true;
		}
		LOG.info("no found user with email " + login + " and password " + oldPassword);
		return false;
	}

	private static int nextId() {
		return ++id;
	}
}
