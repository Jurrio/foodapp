package ua.com.jurimik.dao;

import ua.com.jurimik.model.Meal;

public interface MealDAO {

	public boolean add(Meal meal);

	public Meal get(int id);

	public boolean update(int id, Meal meal);

	public boolean delete(Meal meal);

}
