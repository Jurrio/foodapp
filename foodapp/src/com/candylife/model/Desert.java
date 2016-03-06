package com.candylife.model;

import java.util.Date;

import com.candylife.interfaces.Desertable;

public class Desert extends Meal implements Desertable {

	public Desert(String title, String description, boolean available, double price, String owner, Date time) {
		super(title, description, available, price, owner, time);
		// TODO Auto-generated constructor stub
	}

}
