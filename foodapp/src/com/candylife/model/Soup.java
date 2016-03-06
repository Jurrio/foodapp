package com.candylife.model;

import java.util.Date;

import com.candylife.interfaces.Soupable;

public class Soup extends Meal implements Soupable {

	public Soup(String title, String description, boolean available, double price, String owner, Date time) {
		super(title, description, available, price, owner, time);
	}

	public Soup() {
		super();
	}

}
