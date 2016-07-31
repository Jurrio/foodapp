package ua.com.jurimik.dao;

import java.io.File;
import java.util.List;

import ua.com.jurimik.exception.NotImplementedMethodException;
import ua.com.jurimik.exception.StringFormatException;
import ua.com.jurimik.list.CacheList;
import ua.com.jurimik.model.Meal;

public class MealSerializationDAOImpl implements MealSerializationDAO {

	private static File file = new File("serialStorage");
	private List<Meal> cacheList = new CacheList<Meal>(file);

	@Override
	public boolean add(Meal meal) {
		return cacheList.add(meal);
	}

	@Override
	public Meal get(int id) {
		return cacheList.get(id);
	}

	@Override
	public boolean update(int id, Meal meal) {
		return (cacheList.set(id, meal) != null); 
	}

	@Override
	public boolean delete(Meal meal) {
		return (cacheList.remove(meal));
	}

	@Override
	public String convertToString(Meal meal) throws NotImplementedMethodException {
		throw new NotImplementedMethodException();
	}

	@Override
	public Meal convertFromString(String string) throws StringFormatException, NotImplementedMethodException {
		throw new NotImplementedMethodException();
	}

}
