package ua.com.jurimik.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.dao.ListMealDAOImpl;
import ua.com.jurimik.model.Meal;

public class MealService {

	private static final Logger LOG = LogManager.getLogger(MealService.class);

	public static boolean add(Meal meal) {
		LOG.info("Call to MealRepository.add");
		return new ListMealDAOImpl().add(meal);
	}

	public static List<Meal> find(String search) {
		LOG.info("Call to MealRepository.find");
		return new ListMealDAOImpl().find(search);
	}

	public static boolean delete(Meal meal) {
		LOG.info("Call to MealRepository.delete(id)");
		return new ListMealDAOImpl().delete(meal);
	}

	public static boolean delete(int id) {
		LOG.info("Call to MealRepository.delete(id)");
		return new ListMealDAOImpl().delete(id);
	}

	public static List<Meal> showAll() {
		LOG.info("Call to MealRepository.getAll");
		return new ListMealDAOImpl().getAll();
	}
}
