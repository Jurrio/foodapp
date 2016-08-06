package ua.com.jurimik.dao.list;

import java.util.List;

import ua.com.jurimik.dao.MealDAO;
import ua.com.jurimik.model.Meal;

public interface ListMealDAO extends MealDAO {

	public boolean delete(int id);

	public List<Meal> find(String searchString);

	public List<Meal> getAll();

}
