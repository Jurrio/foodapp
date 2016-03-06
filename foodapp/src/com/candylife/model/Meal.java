package com.candylife.model;

import java.util.Date;

public abstract class Meal {
	private String title;
	private String description;
	private boolean available;
	private double price;
	private String owner; //TODO: change to class Person after create it.
	private Date time;

	public Meal(String title, String description, boolean available, double price, String owner, Date time) {
		this.title = title;
		this.description = description;
		this.available = available;
		this.setPrice(price); 
		this.owner = owner;
		this.time = time;
	}
	
	public Meal() {
		
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

	public Date getTime() {
		return time;
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

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return title + " " + description + " " + price + " " + owner + " " + time;
	}	
	
	
}
