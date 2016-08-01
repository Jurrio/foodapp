package ua.com.jurimik.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.model.User;

public class ListPersonDAOImpl implements PersonListDAO {

	private static List<User> personList = new ArrayList<>();
	private static int id = 0;

	private static final Logger LOG = LogManager.getLogger(ListPersonDAOImpl.class);

	@Override
	public boolean add(User person) {
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
	public User get(int id) {
		for (User person : personList) {
			if (person.getId() == id) {
				return person;
			}
		}
		return null; // TODO: replace the null exception
	}

	@Override
	public int login(String login, String password) {
		User usr = new UserBuilder().email(login).password(password).build();
		for (User p : personList) {
			if (p.equals(usr)) {
				LOG.info("get person (id " + p.getId());
				return p.getId();
			}
		}
		LOG.info("no found user with email " + login + " and password " + password);
		return 0;
	}

	@Override
	public boolean update(int id, User person) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getId() == id) {
				personList.set(i, person);
				break;
			}
		}
		return personList.contains(person);
	}

	@Override
	public boolean delete(User deletedPerson) {
		for (User p : personList) {
			if (p.equals(deletedPerson)) {
				return personList.remove(deletedPerson);
			}
		}
		return false;
	}

	private static int nextId() {
		return ++id;
	}
}
