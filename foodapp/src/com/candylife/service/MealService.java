package com.candylife.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.candylife.dao.MealRepository;
import com.candylife.model.Desert;
import com.candylife.model.MainCourse;
import com.candylife.model.Meal;
import com.candylife.model.Soup;
import com.candylife.util.MealUtil;

public class MealService {
	public static void add(String title, String description, String type, String available, String price, String owner, String time){
		boolean isAvailable = available != null;
		try {
			double dPrice = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			//TODO: add anything :^)
		}
		Date date = new Date(); //TODO: date format in html
		Meal meal = MealUtil.create(type);
		new MealRepository().create(meal);
	}
	
	public static List<Meal> find(String search) {
		ArrayList<Meal> meals = MealRepository.getMealList();
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
		for (Meal meal : MealRepository.getMealList()) {
			if (meal.getTitle().equals(title) && meal.getDescription().equals(description) && meal.getPrice() == dPrice) {
				new MealRepository().delete(meal);
				break;
			}
		}
	}
}
