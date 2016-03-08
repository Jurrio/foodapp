package com.candylife.service;

import java.util.Date;
import java.util.List;

import com.candylife.dao.MealRepository;
import com.candylife.model.Meal;
import com.candylife.util.MealUtil;

public class MealService {
	public static boolean add(String title, String description, String type, String available, String price, String owner, String time){
		boolean isAvailable = available != null;
		double dPrice = 0;
		try {
			dPrice = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			//TODO: add anything :^)
		}
		Date date = new Date(); //TODO: date format in html
		Meal meal = MealUtil.create(type);
		if (meal != null) {
			MealUtil.init(meal, title, description, isAvailable, dPrice, owner, date);
			new MealRepository().create(meal);
			return true;
		}
		return false;
	}
	
	public static String find(String search) {
		StringBuilder result = new StringBuilder("List of meals on request \"" + search + "\":\n");
		List <Meal> resultList = new MealRepository().read(search);
		for (Meal meal : resultList) {
			result.append(meal.toString() + "\n");
		}
		return result.toString();
	}

	public static void delete(String sId) {
		int id = Integer.parseInt(sId);
		Meal meal = new MealRepository().read(id);
		new MealRepository().delete(meal);
	}

	public static String listAll() {
		StringBuilder result = new StringBuilder("List of meals:\n");
		List<Meal> mealList = new MealRepository().read();
		for (Meal meal : mealList) {
			result.append(meal.toString() + "\n");
		}
		return result.toString();
	}
}
