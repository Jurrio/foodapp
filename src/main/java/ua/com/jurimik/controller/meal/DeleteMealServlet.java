package ua.com.jurimik.controller.meal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.service.MealService;
import ua.com.jurimik.util.ParameterConverter;

@WebServlet(name = "DeleteMealServlet", urlPatterns = "/deleteMeal")
public class DeleteMealServlet extends HttpServlet {

	private static final long serialVersionUID = -407738805277662420L;
	private static final Logger LOG = Logger.getLogger(DeleteMealServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = ParameterConverter.convertInteger(req.getParameter(Parameters.ID));

			boolean isDeleted = MealService.delete(id);

			if (isDeleted) {
				LOG.info("meal deleted");
				req.setAttribute(Parameters.MESSAGE, Messages.DELETE_SUCCEFULLY);
			} else {
				LOG.warn("meal not deleted");
				req.setAttribute(Parameters.ERROR, Messages.DELETE_ERROR);
			}
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
			req.setAttribute(Parameters.ERROR, Messages.DELETE_ERROR);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			req.setAttribute(Parameters.ERROR, Messages.UNKNOWN_EXCEPTION + " " + e.getMessage());
		}
		req.setAttribute(Parameters.MEALS, MealService.showAll());
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}
