package com.candylife.dao;

import java.util.ArrayList;
import java.util.List;

import com.candylife.interfaces.MealCRUD;
import com.candylife.model.Meal;

public class MealRepository implements MealCRUD{
	private static ArrayList<Meal> mealList = new ArrayList<>();

	@Override
	public boolean create(Meal meal) {
		mealList.add(meal);
		return true;
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
	public List<Meal> read(String search) {
		return find(search);
	}

	@Override
	public void update(int index, Meal meal) {
		mealList.set(index, meal);		
	}

	@Override
	public boolean delete(Meal meal) {
		if (meal != null) {
			mealList.remove(meal);
			return true;
		}
		return false;
	}
	
	@Override
	public void delete(int id) {
		mealList.remove(selectById(id));		
	}
	
	private Meal selectById(int id) {
		for (Meal meal : mealList) {
			if (id == meal.getId()) {
				return meal;
			}
		}
		return null;
	}
	
	private List<Meal> find(String search) {
		ArrayList<Meal> result = new ArrayList<>();
		for (int i = 0; i < mealList.size(); i++) {
			String[] values = mealList.get(i).toString().split(" ");
			for (String s : values) {
				if (search.equals(s)) {
					result.add(new MealRepository().read(i));
					break;
				}
			}
		}
		return result;
	}
}
