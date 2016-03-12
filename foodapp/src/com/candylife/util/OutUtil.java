package com.candylife.util;

import java.util.List;

import com.candylife.constants.Fields;
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

	public static String printMeal(Meal meal) {
		StringBuilder builder = new StringBuilder(Servlet.ADD_SUCSEFULLY + "\n");
		builder.append(Fields.ID + ": " + meal.getId() + "\n");
		builder.append(Fields.TITLE + ": " + meal.getTitle() + "\n");
		builder.append(Fields.DESCRIPTION + ": " + meal.getDescription() + "\n");
		builder.append(Fields.TYPE + ": " + meal.getType() + "\n");
		builder.append(Fields.AVAILABLE + ": " + meal.isAvailable() + "\n");
		builder.append(Fields.PRICE + ": " + meal.getPrice() + "\n");
		builder.append(Fields.OWNER + ": " + meal.getOwner() + "\n");
		return builder.toString();
	}

}
