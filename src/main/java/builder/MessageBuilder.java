package main.java.builder;

import java.util.List;

import main.java.constant.Messages;
import main.java.constant.Parameters;
import main.java.model.Meal;

public class MessageBuilder {

	public static String buildStringFromList(List<Meal> listMeal) {
		StringBuilder builder = new StringBuilder(Messages.LIST_OF_MEALS);
		for (Meal meal : listMeal) {
			builder.append(meal.toString());
			builder.append("\n");
		}
		builder.append(String.format(Messages.SIZE_OF_LIST, listMeal.size()));
		return builder.toString();
	}

	public static String buildStringFromMeal(Meal meal) {
		StringBuilder builder = new StringBuilder(Messages.ADD_SUCCEFULLY + "\n");
		builder.append(Parameters.ID + ": " + meal.getId() + "\n");
		builder.append(Parameters.TITLE + ": " + meal.getTitle() + "\n");
		builder.append(Parameters.DESCRIPTION + ": " + meal.getDescription() + "\n");
		builder.append(Parameters.AVAILABLE + ": " + meal.isAvailable() + "\n");
		builder.append(Parameters.PRICE + ": " + meal.getPrice() + "\n");
		builder.append(Parameters.OWNER + ": " + meal.getOwner() + "\n");
		return builder.toString();
	}

}
