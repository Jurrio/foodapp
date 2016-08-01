package ua.com.jurimik.controller.meal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.model.Meal;
import ua.com.jurimik.service.MealService;

@WebServlet(name = "ListMealServlet", urlPatterns = "/listMeal")
public class ListMealController extends HttpServlet {

	private static final long serialVersionUID = 2027448965537193995L;
	private static Logger LOG = Logger.getLogger(ListMealController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Meal> allMeals = MealService.showAll();

		req.setAttribute(Parameters.MEALS, allMeals);
		LOG.debug("size of allMeals: " + allMeals.size());
		if (!allMeals.isEmpty()) {
			req.setAttribute(Parameters.MESSAGE, Messages.DISPLAY_ALL);
		} else {
			req.setAttribute(Parameters.ERROR, Messages.EMPTY_SET);
		}
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}