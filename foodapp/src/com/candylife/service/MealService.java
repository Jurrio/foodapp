package com.candylife.service;

import java.util.List;

import com.candylife.dao.MealRepository;
import com.candylife.model.Meal;

public class MealService {
	public static boolean add(Meal meal){
		return new MealRepository().create(meal); 
	}
	
	public static List<Meal> find(String search) {
		return new MealRepository().read(search);
	}

	public static boolean delete(int id) {
		return new MealRepository().delete(id);
	}

	public static List<Meal> showAll() {
		return new MealRepository().read();
	}
}
