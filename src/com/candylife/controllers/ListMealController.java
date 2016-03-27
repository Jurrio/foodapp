package com.candylife.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.ServletConstant;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;

@WebServlet (name = "ListMealServlet", urlPatterns = "/listMeal")
public class ListMealController extends HttpServlet {

	private static final long serialVersionUID = 2027448965537193995L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
		List<Meal> allMeals = MealService.showAll();
		
		req.setAttribute("meals", allMeals);
		
		if (!allMeals.isEmpty()) {
			ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.DISPLAY_ALL);
			disp.forward(req, resp);
		} else {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.EMPTY_SET);
			disp.forward(req, resp);
//			writer.println(ServletConstant.EMPTY_SET);
		}
	}
}
