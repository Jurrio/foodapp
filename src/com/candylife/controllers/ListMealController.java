package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.builder.MessageBuilder;
import com.candylife.constants.ServletConstant;
import com.candylife.model.Meal;
import com.candylife.service.MealService;

@WebServlet (name = "ListMealServlet", urlPatterns = "/listMeal")
public class ListMealController extends HttpServlet {

	private static final long serialVersionUID = 2027448965537193995L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Meal> allMeals = MealService.showAll();
		
		PrintWriter writer = resp.getWriter();
		if (!allMeals.isEmpty()) {
			writer.println(MessageBuilder.buildStringFromList(allMeals));
		} else {
			writer.println(ServletConstant.EMPTY_SET);
		}
	}
}
