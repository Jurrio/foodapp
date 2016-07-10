package main.java.dao;

import main.java.model.Meal;

public interface AbstractMealDAO {
	
	public boolean add(Meal meal);
	public Meal get (int id);
	public boolean update(int id, Meal meal);
	public boolean delete(Meal meal);

}
