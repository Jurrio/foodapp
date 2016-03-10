package com.candylife.service;

import java.util.Date;
import java.util.List;

import com.candylife.constants.Servlet;
import com.candylife.dao.MealRepository;
import com.candylife.model.Meal;
import com.candylife.util.CheckUtil;
import com.candylife.util.MealUtil;

public class MealService {
	public static String add(String title, String description, String type, String available, String price, String owner, String time){
		String result = "";
		boolean isAvailable = CheckUtil.parseAvailable(available);
		double dPrice = CheckUtil.parsePrice(price);
		Date date = new Date(); //TODO: date format in html
		Meal meal = MealUtil.create(type);
		if (new MealRepository().create(meal)) {
			MealUtil.init(meal, title, description, isAvailable, dPrice, owner, date);
			return Servlet.ADD_SUCSEFULLY + "\n" + meal.toString();
		}
		return Servlet.ADD_ERROR; 
	}
	
	public static String find(String search) {
		StringBuilder result = new StringBuilder(String.format(Servlet.SEARCH_RESPONSE, search));
		List <Meal> resultList = new MealRepository().read(search);
		if (resultList.size() > 0) {
			for (Meal meal : resultList) {
				result.append(meal.toString() + "\n");
			}
		} else {
			result.append(Servlet.SEARCH_NULL);
		}
		return result.toString();
	}

	public static String delete(String sId) {
		int id = Integer.parseInt(sId);
		Meal meal = new MealRepository().read(id);
		if (new MealRepository().delete(meal)) {
			return Servlet.DELETE_SUCSEFULLY;
		}
		return Servlet.DELETE_ERROR;
		
	}

	public static String listAll() {
		StringBuilder result = new StringBuilder(Servlet.LIST_OF_MEALS + "\n");
		List<Meal> mealList = new MealRepository().read();
		for (Meal meal : mealList) {
			result.append(meal.toString() + "\n");
		}
		return result.toString();
	}
}
