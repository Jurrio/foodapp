package com.candylife.util;

import com.candylife.model.Desert;
import com.candylife.model.MainCourse;
import com.candylife.model.Meal;
import com.candylife.model.Soup;

public class MealUtil {
	public static Meal create(String type) {
		switch (type) {
		case "soup":
			return new Soup();
		case "mainCourse":
			return new MainCourse();
		case "desert":
			return new Desert();
		default:
			return null;
		}
	}
}
