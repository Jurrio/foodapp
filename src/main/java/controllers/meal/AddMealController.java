package main.java.controllers.meal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.java.builder.MealBuilder;
import main.java.constants.Parameters;
import main.java.constants.Messages;
import main.java.model.Meal;
import main.java.service.MealService;
import main.java.util.ControllerUtil;
import main.java.util.Parser;

@WebServlet(name = "AddMealServlet", urlPatterns = "/addMeal")
public class AddMealController extends HttpServlet {

	private static final long serialVersionUID = 3016401691472518340L;
	private static final Logger LOG = LogManager.getLogger(AddMealController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControllerUtil.setAttributes(req, Messages.VOID, Messages.VOID);
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IllegalArgumentException {
		try {
			String title = req.getParameter(Parameters.TITLE);
			String description = req.getParameter(Parameters.DESCRIPTION);
			boolean available = Parser.parseAvailable(req.getParameter(Parameters.AVAILABLE));
			double price = Parser.parsePrice(req.getParameter(Parameters.PRICE));
			String owner = req.getParameter(Parameters.OWNER);
			LOG.debug("{title: " + title + ", description: " + description + ", available: " + available + 
					", price: " + price + ", owner: "  + owner + "}");

			Meal meal = new MealBuilder(title, price).available(available).owner(owner).description(description)
					.build();
			LOG.debug("create meal " + meal.toString());

			boolean isAdded = MealService.add(meal);
			if (isAdded) {
				LOG.info("meal added");
				ControllerUtil.setAttributes(req, Messages.YES, Messages.ADD_SUCCEFULLY);
				req.setAttribute(Parameters.MEAL_ID, meal.getId());
				LOG.debug("set attribute " + Parameters.MEAL_ID + ": " + meal.getId());
			} else {
				LOG.warn("meal not added");
				ControllerUtil.setAttributes(req, Messages.NO, Messages.ADD_ERROR);
			}
		} catch (Exception e) { //TODO: catch each exception
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, Messages.NO, Messages.UNKNOWN_EXCEPTION);
		}
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
}
