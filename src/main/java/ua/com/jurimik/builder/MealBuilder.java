package ua.com.jurimik.builder;

import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.model.Meal;

public class MealBuilder {
	private final String title;
	private final double price;
	private String description = Parameters.NO_DESCRIPTION;
	private boolean available = false;
	private String owner = Parameters.NO_OWNER;

	public MealBuilder(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public MealBuilder description(String description) {
		this.description = description;
		return this;
	}

	public MealBuilder owner(String owner) { // TODO: change to User
		this.owner = owner;
		return this;
	}

	public MealBuilder available(boolean available) {
		this.available = available;
		return this;
	}

	public Meal build() {
		Meal meal = new Meal(title, price);
		meal.setDescription(description);
		meal.setAvailable(available);
		meal.setOwner(owner);
		return meal;
	}

}
