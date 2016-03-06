package com.candylife.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.service.MealService;

public class DeleteMeal extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		
		MealService.delete(title, description, price);
	}

}
