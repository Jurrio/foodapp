package com.candylife.util;

import com.candylife.builder.MealBuilder;
import com.candylife.model.Meal;

public class MealUtil {

	public static Meal create(MealBuilder mealBuilder) {
		Meal meal = new Meal(mealBuilder);
		return meal;
	}
	
}
