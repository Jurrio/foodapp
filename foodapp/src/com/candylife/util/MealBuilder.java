package com.candylife.util;

import com.candylife.constants.WebPage;

public class MealBuilder {
	private final String title;
	private final double price;
	private String description = WebPage.NO_DESCRIPTION;
	private boolean available = false;
	private String owner = WebPage.NO_OWNER;
	
	public MealBuilder(String title, double price) {
		this.title = title;
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
}
