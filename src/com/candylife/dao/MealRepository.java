package com.candylife.dao;

import java.util.ArrayList;
import java.util.List;

import com.candylife.model.Meal;

public class MealRepository {
	private static List<Meal> mealList = new ArrayList<>();
	private static int id = 0;

	public static boolean add(Meal meal) {
		if (mealList.contains(meal)) return false;
		meal.setId(nextId());
		mealList.add(meal);
		return mealList.contains(meal);
	}
	
	public static boolean delete(int id) {
		for (Meal meal : mealList) {
			if (id == meal.getId()) {
				mealList.remove(meal);
				return true;
			}
		}
		return false;
	}
	
	public static List<Meal> find(String search) {
		List<Meal> result = new ArrayList<>();
		for (Meal meal : mealList) {
			String[] values = meal.toString().split(" ");
			for (String s : values) {
				if (search.equals(s)) {
					result.add(meal);
					break;
				}
			}
		}
		return result;
	}

	public static List<Meal> getAll() {
		return mealList;
	}
	
	private static int nextId() {
		return ++id;
	}
}
