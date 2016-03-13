package com.candylife.util;

import com.candylife.builder.MealBuilder;
import com.candylife.model.Meal;

public class MealUtil {

	public static Meal create(MealBuilder mealBuilder) throws NullPointerException {
		return new Meal(mealBuilder);
	}
	
}
