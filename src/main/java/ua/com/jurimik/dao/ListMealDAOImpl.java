package ua.com.jurimik.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.com.jurimik.model.Meal;

public class ListMealDAOImpl implements ListMealDAO {
	private static List<Meal> mealList = new ArrayList<>();
	private static int id = 0;

	private static final Logger LOG = LogManager.getLogger(ListMealDAOImpl.class);

	@Override
	public boolean add(Meal meal) {
		if (mealList.contains(meal)) {
			LOG.info("DB exists this meal already");
			return false;
		}
		meal.setId(nextId());
		LOG.info("meal got id " + meal.getId());
		LOG.info("in meallist added meal " + meal.getId());
		return mealList.add(meal);
	}

	@Override
	public Meal get(int id) {
		for (Meal meal : mealList) {
			if (meal.getId() == id) {
				return meal;
			}
		}
		return null; // TODO replace null for exception
	}

	@Override
	public boolean update(int id, Meal meal) {
		for (int i = 0; i < mealList.size(); i++) {
			if (mealList.get(i).getId() == id) {
				mealList.set(i, meal);
				break;
			}
		}
		return mealList.contains(meal);
	}

	@Override
	public boolean delete(Meal deletedMeal) {
		int id = deletedMeal.getId();
		return delete(id);
	}

	@Override
	public boolean delete(int id) {
		for (Meal meal : mealList) {
			if (id == meal.getId()) {
				mealList.remove(meal);
				LOG.info("delete meal " + meal.getId());
				return true;
			}
		}
		LOG.info("no meal with id " + id + " in database");
		return false;
	}

	@Override
	public List<Meal> find(String search) {
		List<Meal> result = new ArrayList<>();
		for (Meal meal : mealList) {
			String[] values = meal.toString().split(" ");
			for (String s : values) {
				if (search.equals(s)) {
					result.add(meal);
					LOG.info("added meal " + meal.getId() + " to result");
					break;
				}
			}
		}
		LOG.info("finish of find " + search + ". Found " + result.size() + " results");
		return result;
	}

	@Override
	public List<Meal> getAll() {
		LOG.info("get the whole list");
		return mealList;
	}

	private static int nextId() {
		return ++id;
	}

}
