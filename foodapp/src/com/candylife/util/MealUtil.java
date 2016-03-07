package com.candylife.util;

import com.candylife.constants.WebPage;
import com.candylife.model.Desert;
import com.candylife.model.MainCourse;
import com.candylife.model.Meal;
import com.candylife.model.Soup;

public class MealUtil {
	public static Meal create(String type) {
		switch (type) {
		case WebPage.TYPE_SOUP:
			return new Soup();//TODO: add setters
		case WebPage.TYPE_MAIN_COURSE:
			return new MainCourse();//TODO: add setters
		case WebPage.TYPE_DESERT:
			return new Desert();//TODO: add setters
		default:
			return null;
		}
	}
}
