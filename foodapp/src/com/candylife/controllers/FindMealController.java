package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.ServletConstant;
import com.candylife.builder.MessageBuilder;
import com.candylife.constants.RequestParam;
import com.candylife.model.Meal;
import com.candylife.service.MealService;

@WebServlet(name = "FindMealServtet", urlPatterns = "/findMeal")
public class FindMealController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchValue = req.getParameter(RequestParam.SEARCH);
		
		List<Meal> findResult = MealService.find(searchValue);
		
		PrintWriter out = resp.getWriter();
		if (!findResult.isEmpty()) {
			out.println(MessageBuilder.buildStringFromList(findResult));
		} else {
			out.println(ServletConstant.EMPTY_SET);
		}
	}
}
