package com.candylife.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.candylife.dao.MealRepository;
import com.candylife.model.Meal;

public class MealService {
	
	public static final Logger LOG = LogManager.getLogger(MealService.class.getName());
	
	public static boolean add(Meal meal){
		LOG.info("Call to MealRepository.add");
		return MealRepository.add(meal); 
	}
	
	public static List<Meal> find(String search) {
		LOG.info("Call to MealRepository.find");
		return MealRepository.find(search);
	}

	public static boolean delete(int id) {
		LOG.info("Call to MealRepository.delete");
		return MealRepository.delete(id);
	}

	public static List<Meal> showAll() {
		LOG.info("Call to MealRepository.getAll");
		return MealRepository.getAll();
	}
}
