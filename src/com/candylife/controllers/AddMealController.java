package com.candylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.builder.MealBuilder;
import com.candylife.constants.RequestParam;
import com.candylife.constants.ServletConstant;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;
import com.candylife.util.Parser;

@WebServlet (name = "AddMealServlet", urlPatterns = "/addMeal")
public class AddMealController extends HttpServlet {

	private static final long serialVersionUID = 3016401691472518340L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("add.jsp");
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalArgumentException {
		RequestDispatcher disp = req.getRequestDispatcher("add.jsp");
		try {
			String title = req.getParameter(RequestParam.TITLE);
			String description = req.getParameter(RequestParam.DESCRIPTION);
			boolean available = Parser.parseAvailable(req.getParameter(RequestParam.AVAILABLE));
			double price = Parser.parsePrice(req.getParameter(RequestParam.PRICE));
			String owner = req.getParameter(RequestParam.OWNER);

			Meal meal = new MealBuilder(title, price).available(available).owner(owner).description(description).build();

			boolean isAdded = MealService.add(meal);
			if (isAdded) {
				ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.ADD_SUCCEFULLY);
				req.setAttribute(RequestParam.MEAL_ID, meal.getId());
				disp.forward(req, resp);
			} else {
				ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.ADD_ERROR);
				disp.forward(req, resp);
			}
		} catch (NullPointerException e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.ADD_ERROR);
			disp.forward(req, resp);
		} catch (IllegalArgumentException e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.TYPE_ERROR);
			disp.forward(req, resp);
		} catch (Exception e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.UNKNOWN_EXCEPTION);
			disp.forward(req, resp);
		}
	}	
}
