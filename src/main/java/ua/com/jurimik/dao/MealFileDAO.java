package ua.com.jurimik.dao;

import ua.com.jurimik.model.Meal;
import ua.com.jurimik.exception.NotImplementedMethodException;
import ua.com.jurimik.exception.StringFormatException;

public interface MealFileDAO extends MealDAO {

	public String convertToString(Meal meal) throws NotImplementedMethodException;

	public Meal convertFromString(String string) throws StringFormatException, NotImplementedMethodException;

}
