package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.WebPage;
import com.candylife.service.MealService;

@WebServlet ("/addMeal")
public class AddMealConroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter(WebPage.TITLE);
		String description = req.getParameter(WebPage.DESCRIPTION);
		String type = req.getParameter(WebPage.TYPE);
		String available = req.getParameter(WebPage.AVAILABLE);
		String price = req.getParameter(WebPage.PRICE);
		String owner = req.getParameter(WebPage.OWNER);
		String time = req.getParameter(WebPage.TIME);
		
		MealService.add(title, description, type, available, price, owner, time);
		
		
	}	
}
