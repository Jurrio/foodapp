package com.candylife.service;

import java.util.List;

import com.candylife.constants.Servlet;
import com.candylife.dao.MealRepository;
import com.candylife.model.Meal;
import com.candylife.util.CheckUtil;
import com.candylife.util.MealUtil;

public class MealService {
	public static boolean add(Meal meal){
		return new MealRepository().create(meal); 
	}
	
	public static List find(String search) {
		return new MealRepository().read(search);
	}

	public static boolean delete(int id) {
		return new MealRepository().delete(id);
	}

	public static List showAll() {
		return new MealRepository().read();
	}
}
