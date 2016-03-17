package com.candylife.builder;

import com.candylife.constants.RequestParam;
import com.candylife.enums.Type;
import com.candylife.model.Meal;

public class MealBuilder {
	private final String title;
	private final double price;
	private final Type type; //TODO: change to enum
	private String description = RequestParam.NO_DESCRIPTION;
	private boolean available = false;
	private String owner = RequestParam.NO_OWNER;
	
	public MealBuilder(String title, Type type, double price) {
		this.title = title;
		this.type = type;
		this.price = price;
	}
	
	public MealBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public MealBuilder owner(String owner) { //TODO: change to Person
		this.owner = owner;
		return this;
	}
	
	public MealBuilder available(boolean available) {
		this.available = available;
		return this;
	}

	public String getTitle() {
		return title;
	}
	
	public Type getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getOwner() {
		return owner;
	}

	public Meal build() {
		Meal meal = new Meal(title, price);
		meal.setType(type);
		meal.setDescription(description);
		meal.setAvailable(available);
		meal.setOwner(owner);
		return meal;
	}
	
	
}
