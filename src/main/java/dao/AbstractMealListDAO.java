package main.java.dao;

import java.util.List;

import main.java.model.Meal;

public interface AbstractMealListDAO extends AbstractMealDAO {
	
	public boolean delete(int id);
	public List<Meal> find(String searchString);
	public List<Meal> getAll();

}
