package com.candylife.model;

import com.candylife.builder.MealBuilder;
import com.candylife.enums.Type;

public class Meal {
	private static int countId = 0;
	
	private int id;
	private String title;
	private String description;
	private Type type;
	private boolean available;
	private double price;
	private String owner; //TODO: change to class Person after create it.
	
	@Deprecated
	public Meal(MealBuilder builder) {
		this.id = nextId();
		this.title = builder.getTitle();
		this.type = builder.getType();
		this.description = builder.getDescription();
		this.available = builder.isAvailable();
		this.price = builder.getPrice();
		this.owner = builder.getOwner();
	}
	
	public Meal(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Type getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}

	public double getPrice() {
		return price;
	}

	public String getOwner() {
		return owner;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return id + " " + title + " " + type + " " + description + " " + price + " " + owner + " ";
	}
	
	private int nextId() {
		return countId++;
	}
	
}
