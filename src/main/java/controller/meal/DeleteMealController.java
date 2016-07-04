package main.java.controller.meal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.constant.Messages;
import main.java.constant.Parameters;
import main.java.service.MealService;
import main.java.util.ControllerUtil;
import main.java.util.Parser;

@WebServlet(name = "DeleteMealServlet", urlPatterns = "/deleteMeal")
public class DeleteMealController extends HttpServlet {

	private static final long serialVersionUID = -407738805277662420L;
	private static final Logger LOG = Logger.getLogger(DeleteMealController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControllerUtil.setAttributes(req, Messages.VOID, Messages.VOID);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Parser.parseId(req.getParameter(Parameters.ID));

			boolean isDeleted = MealService.delete(id);

			if (isDeleted) {
				LOG.info("meal deleted");
				ControllerUtil.setAttributes(req, Messages.YES, Messages.DELETE_SUCCEFULLY);
			} else {
				LOG.warn("meal not deleted");
				ControllerUtil.setAttributes(req, Messages.NO, Messages.DELETE_ERROR);
			}
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, Messages.NO, Messages.DELETE_ERROR);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, Messages.NO, Messages.UNKNOWN_EXCEPTION);
		}
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}
