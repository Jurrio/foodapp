package com.candylife.builder;

import java.util.List;

import com.candylife.constants.RequestParam;
import com.candylife.constants.ServletConstant;
import com.candylife.model.Meal;

public class MessageBuilder {

	public static String buildStringFromList(List<Meal> listMeal) {
		StringBuilder builder = new StringBuilder(ServletConstant.LIST_OF_MEALS);
		for (Meal meal : listMeal) {
			builder.append(meal.toString());
			builder.append("\n");
		}
		builder.append(String.format(ServletConstant.SIZE_OF_LIST, listMeal.size()));
		return builder.toString();
	}

	public static String buildStringFromMeal(Meal meal) {
		StringBuilder builder = new StringBuilder(ServletConstant.ADD_SUCCEFULLY + "\n");
		builder.append(RequestParam.ID + ": " + meal.getId() + "\n");
		builder.append(RequestParam.TITLE + ": " + meal.getTitle() + "\n");
		builder.append(RequestParam.DESCRIPTION + ": " + meal.getDescription() + "\n");
		builder.append(RequestParam.TYPE + ": " + meal.getType() + "\n");
		builder.append(RequestParam.AVAILABLE + ": " + meal.isAvailable() + "\n");
		builder.append(RequestParam.PRICE + ": " + meal.getPrice() + "\n");
		builder.append(RequestParam.OWNER + ": " + meal.getOwner() + "\n");
		return builder.toString();
	}

}
