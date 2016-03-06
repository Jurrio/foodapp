package com.candylife.dao;

import java.util.ArrayList;

import com.candylife.interfaces.MealCRUD;
import com.candylife.model.Meal;

public class MealRepository implements MealCRUD{
	private static ArrayList<Meal> mealList = new ArrayList<>();

	@Override
	public void create(Meal meal) {
		mealList.add(meal);
	}

	@Override
	public Object read(int index) {
		return mealList.get(index);
	}

	@Override
	public void update(int index, Meal meal) {
		mealList.set(index, meal);		
	}

	@Override
	public void delete(Meal meal) {
		mealList.remove(meal);		
	}
	
	public static ArrayList<Meal> getMealList() {
		return mealList;
	}
}
