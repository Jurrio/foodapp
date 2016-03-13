package com.candylife.service;

import java.util.List;

import com.candylife.dao.MealRepository;
import com.candylife.model.Meal;

public class MealService {
	public static boolean add(Meal meal){
		return MealRepository.add(meal); 
	}
	
	public static List<Meal> find(String search) {
		return MealRepository.find(search);
	}

	public static boolean delete(int id) {
		return MealRepository.delete(id);
	}

	public static List<Meal> showAll() {
		return MealRepository.getAll();
	}
}
