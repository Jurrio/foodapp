package com.candylife.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.candylife.constants.ServletConstant;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;

@WebServlet (name = "ListMealServlet", urlPatterns = "/listMeal")
public class ListMealController extends HttpServlet {

	private static final long serialVersionUID = 2027448965537193995L;
	private static Logger LOG = Logger.getLogger(ListMealController.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Meal> allMeals = MealService.showAll();
		
		req.setAttribute("meals", allMeals);
		LOG.debug("size of allMeals: " + allMeals.size());
		if (!allMeals.isEmpty()) {
			ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.DISPLAY_ALL);
		} else {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.EMPTY_SET);
		}
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}
