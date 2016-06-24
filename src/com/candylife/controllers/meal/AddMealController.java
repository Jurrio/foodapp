package com.candylife.controllers.meal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.candylife.builder.MealBuilder;
import com.candylife.constants.RequestParam;
import com.candylife.constants.ServletConstant;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;
import com.candylife.util.Parser;

@WebServlet(name = "AddMealServlet", urlPatterns = "/addMeal")
public class AddMealController extends HttpServlet {

	private static final long serialVersionUID = 3016401691472518340L;
	private static final Logger LOG = LogManager.getLogger(AddMealController.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IllegalArgumentException {
		try {
			String title = req.getParameter(RequestParam.TITLE);
			String description = req.getParameter(RequestParam.DESCRIPTION);
			boolean available = Parser.parseAvailable(req.getParameter(RequestParam.AVAILABLE));
			double price = Parser.parsePrice(req.getParameter(RequestParam.PRICE));
			String owner = req.getParameter(RequestParam.OWNER);
			LOG.debug("{title: " + title + ", description: " + description + ", available: " + available + 
					", price: " + price + ", owner: "  + owner + "}");

			Meal meal = new MealBuilder(title, price).available(available).owner(owner).description(description)
					.build();
			LOG.debug("create meal " + meal.toString());

			boolean isAdded = MealService.add(meal);
			if (isAdded) {
				LOG.info("meal added");
				ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.ADD_SUCCEFULLY);
				req.setAttribute(RequestParam.MEAL_ID, meal.getId());
				LOG.debug("set attribute " + RequestParam.MEAL_ID + ": " + meal.getId());
			} else {
				LOG.warn("meal not added");
				ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.ADD_ERROR);
			}
		} catch (Exception e) { //TODO: catch each exception
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.UNKNOWN_EXCEPTION);
		}
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
}
