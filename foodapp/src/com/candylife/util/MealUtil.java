package com.candylife.util;

import com.candylife.constants.RequestParam;
import com.candylife.model.Desert;
import com.candylife.model.MainCourse;
import com.candylife.model.Meal;
import com.candylife.model.Soup;

public class MealUtil {
	public static Meal create(String type) {
		switch (type) {
		case RequestParam.TYPE_SOUP:
			return new Soup();
		case RequestParam.TYPE_MAIN_COURSE:
			return new MainCourse();
		case RequestParam.TYPE_DESERT:
			return new Desert();
		default:
			return null;
		}
	}

	public static void init(Meal meal, String title, String description, boolean isAvailable, double dPrice,
			String owner) {
		meal.setTitle(title);
		meal.setDescription(description);
		meal.setAvailable(isAvailable);
		meal.setPrice(dPrice);
		meal.setOwner(owner);
	}
}
