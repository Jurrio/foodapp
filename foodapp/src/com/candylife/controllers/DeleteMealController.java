package com.candylife.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.WebPage;
import com.candylife.service.MealService;

@WebServlet("/deleteMeal")
public class DeleteMealController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter(WebPage.TITLE);
		String description = req.getParameter(WebPage.DESCRIPTION);
		String price = req.getParameter(WebPage.PRICE);
		
		MealService.delete(title, description, price);
	}

}
