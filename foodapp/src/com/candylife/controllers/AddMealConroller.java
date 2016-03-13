package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.ServletConstant;
import com.candylife.builder.MealBuilder;
import com.candylife.constants.RequestParam;
import com.candylife.enums.Type;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.Parser;
import com.candylife.util.MessageBuilder;

@WebServlet (name = "AddMMealServlet", urlPatterns = "/addMeal")
public class AddMealConroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String title = req.getParameter(RequestParam.TITLE);
		String description = req.getParameter(RequestParam.DESCRIPTION);
		Type type = Parser.parseType(req.getParameter(RequestParam.TYPE));
		boolean available = Parser.parseAvailable(req.getParameter(RequestParam.AVAILABLE));
		double price = Parser.parsePrice(req.getParameter(RequestParam.PRICE));
		String owner = req.getParameter(RequestParam.OWNER);
		
		Meal meal = new Meal(new MealBuilder(title, type, price).available(available).owner(owner).description(description));

		boolean isAdded = MealService.add(meal);
		
		PrintWriter out = resp.getWriter();
		
		if (isAdded) {
			out.println(MessageBuilder.buildStringFromMeal(meal));
		} else {
			out.println(ServletConstant.ADD_ERROR);
		}
	}	
}
