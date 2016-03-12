package com.candylife.model;

import java.util.Date;

public abstract class Meal {
	private static int countId = 0;
	
	private int id;
	private String title;
	private String description;
	private boolean available;
	private double price;
	private String owner; //TODO: change to class Person after create it.
	
	public Meal() {
		this.id = nextId();
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

	public boolean isAvailable() {
		return available;
	}

	public double getPrice() {
		return price;
	}

	public String getOwner() {
		return owner;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return title + " " + description + " " + price + " " + owner + " ";
	}
	
	private int nextId() {
		return countId++;
	}
	
}
