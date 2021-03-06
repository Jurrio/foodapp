package ua.com.jurimik.util;

import ua.com.jurimik.model.Meal;

public class MealToStringArrayConverter {

	public static String[] convert(Meal meal) {
		String[] mealArray = new String[6];
		mealArray[0] = String.valueOf(meal.getId());
		mealArray[1] = meal.getTitle();
		mealArray[2] = meal.getDescription();
		mealArray[3] = String.valueOf(meal.isAvailable());
		mealArray[4] = String.valueOf(meal.getPrice());
		mealArray[5] = meal.getOwner();

		return mealArray;
	}
}
