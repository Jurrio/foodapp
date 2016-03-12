package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.Servlet;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.OutUtil;

@WebServlet (name = "ListMealServlet", urlPatterns = "/listMeal")
public class ListMealController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Meal> allMeals = MealService.showAll();
		
		PrintWriter writer = resp.getWriter();
		if (allMeals.size() > 0) {
			writer.println(OutUtil.printList(allMeals));
		} else {
			writer.println(Servlet.EMPTY_SET);
		}
	}
}
