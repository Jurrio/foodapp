package com.candylife.interfaces;

import java.util.List;

import com.candylife.model.Meal;

public interface MealCRUD {
	boolean create(Meal meal);
	Meal read(int index);
	List<Meal> read();
	List<Meal> read(String arg);
	void update(int index, Meal meal);
	boolean delete(Meal meal);
	boolean delete(int index); //id
}
