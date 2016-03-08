package com.candylife.interfaces;

import java.util.List;

import com.candylife.model.Meal;

public interface MealCRUD {
	void create(Meal meal);
	Meal read(int index);
	List<Meal> read();
	List<Meal> read(String arg);
	void update(int index, Meal meal);
	void delete(Meal meal);
	void delete(int index); //id
}
