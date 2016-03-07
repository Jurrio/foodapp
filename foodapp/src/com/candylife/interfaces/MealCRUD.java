package com.candylife.interfaces;

import java.util.List;

import com.candylife.model.Meal;

public interface MealCRUD {
	void create(Meal meal);
	Meal read(int index);
	List read();
	void update(int index, Meal meal);
	void delete(Meal meal);
	void delete(int index); //id
}
