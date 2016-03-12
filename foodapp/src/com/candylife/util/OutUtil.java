package com.candylife.util;

import java.util.List;

import com.candylife.constants.Servlet;
import com.candylife.model.Meal;

public class OutUtil {

	public static String printList(List<Meal> listMeal) {
		StringBuilder builder = new StringBuilder(Servlet.LIST_OF_MEALS);
		for (Meal meal : listMeal) {
			builder.append(meal.toString());
			builder.append("\n");
		}
		builder.append(String.format(Servlet.SIZE_OF_LIST, listMeal.size()));
		return builder.toString();
	}

}
