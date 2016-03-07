package com.candylife.service;

import java.util.ArrayList;
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
	
	public static List<Meal> find(String search) {
		List<Meal> meals = new MealRepository().read();
		ArrayList<Meal> result = new ArrayList<>();
		for (int i = 0; i < meals.size(); i++) {
			String[] values = meals.get(i).toString().split(" ");
			for (String s : values) {
				if (search.equals(s)) {
					result.add(new MealRepository().read(i));
					break;
				}
			}
		}
		return result;		
	}

	public static void delete(String title, String description, String price) {
		double dPrice = Double.parseDouble(price);
		for (Meal meal : new MealRepository().read()) {
			if (meal.getTitle().equals(title) && meal.getDescription().equals(description) && meal.getPrice() == dPrice) {
				new MealRepository().delete(meal);
				break;
			}
		}
	}
}
