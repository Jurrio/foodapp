package com.candylife.dao;

import java.util.ArrayList;
import java.util.List;

import com.candylife.interfaces.MealCRUD;
import com.candylife.model.Meal;

public class MealRepository implements MealCRUD{
	private static ArrayList<Meal> mealList = new ArrayList<>();

	@Override
	public void create(Meal meal) {
		mealList.add(meal);
	}

	@Override
	public Meal read(int id) {
		return selectById(id);
	}

	@Override
	public List<Meal> read() {
		return mealList;
	}

	@Override
	public void update(int index, Meal meal) {
		mealList.set(index, meal);		
	}

	@Override
	public void delete(Meal meal) {
		mealList.remove(meal);		
	}
	
	@Override
	public void delete(int id) {
		mealList.remove(selectById(id));		
	}
	
	public static Meal selectById(int id) {
		for (Meal meal : mealList) {
			if (id == meal.getId()) {
				return meal;
			}
		}
		return null;
	}
}
