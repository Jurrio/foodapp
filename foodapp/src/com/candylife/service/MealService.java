package com.candylife.service;

import java.util.Date;

import com.candylife.dao.MealRepository;
import com.candylife.model.Desert;
import com.candylife.model.MainCourse;
import com.candylife.model.Meal;
import com.candylife.model.Soup;

public class MealService {
	public static void add(String title, String description, String type, String available, String price, String owner, String time){
		boolean isAvailable = available != null;
		double dPrice = Double.parseDouble(price);
		Date date = new Date(); //TODO: date format in html
		Meal meal = null;
		switch (type) {
		case "soup":
			meal = new Soup(title, description, isAvailable, dPrice, owner, date);
			break;
		case "mainCourse":
			meal = new MainCourse(title, description, isAvailable, dPrice, owner, date);
			break;
		case "desert":
			meal = new Desert(title, description, isAvailable, dPrice, owner, date);
		default:
			break;
		}
		new MealRepository().create(meal);
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
