package ua.com.jurimik.servlet.meal;

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
import ua.com.jurimik.exception.SearchEmptyException;
import ua.com.jurimik.exception.SearchManyParamException;
import ua.com.jurimik.model.Meal;
import ua.com.jurimik.service.MealService;
import ua.com.jurimik.util.CheckUtil;

@WebServlet(name = "FindMealServtet", urlPatterns = "/findMeal")
public class FindMealServlet extends HttpServlet {

	private static final long serialVersionUID = -2982563367087578687L;
	private static final Logger LOG = Logger.getLogger(FindMealServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String searchValue = CheckUtil.checkSearchvalue(req.getParameter(Parameters.SEARCH));
			List<Meal> findResult = MealService.find(searchValue);
			LOG.info("found meals: " + findResult.size());

			if (!findResult.isEmpty()) {
				req.setAttribute(Parameters.MESSAGE, Messages.SEARCH_RESPONSE + searchValue);
				req.setAttribute(Parameters.MEALS, findResult);
			} else {
				req.setAttribute(Parameters.ERROR, Messages.EMPTY_SET);
			}

		} catch (SearchManyParamException e) {
			LOG.error(e.getMessage());
			req.setAttribute(Parameters.ERROR, e.getMessage());
		} catch (SearchEmptyException e) {
			LOG.error(e.getMessage());
			req.setAttribute(Parameters.ERROR, e.getMessage());
		}
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}