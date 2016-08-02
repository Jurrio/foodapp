package ua.com.jurimik.dao;

import java.util.List;

import ua.com.jurimik.model.Meal;

public interface ListMealDAO extends MealDAO {

	public boolean delete(int id);

	public List<Meal> find(String searchString);

	public List<Meal> getAll();

}
