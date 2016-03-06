package com.candylife.interfaces;

import com.candylife.model.Meal;

public interface MealCRUD {
	void create(Meal meal);
	Object read(int index);
	void update(int index, Meal meal);
	void delete(Meal meal);
}
