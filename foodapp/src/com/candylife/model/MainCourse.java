package com.candylife.model;

import java.util.Date;

import com.candylife.interfaces.MainCoursable;

public class MainCourse extends Meal implements MainCoursable {

	public MainCourse(String title, String description, boolean available, double price, String owner, Date time) {
		super(title, description, available, price, owner, time);
		// TODO Auto-generated constructor stub
	}

	public MainCourse() {
		// TODO Auto-generated constructor stub
	}

}
