package com.candylife.controllers.meal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.candylife.constants.ServletConstant;
import com.candylife.constants.RequestParam;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;
import com.candylife.util.Parser;

@WebServlet(name = "DeleteMealServlet", urlPatterns = "/deleteMeal")
public class DeleteMealController extends HttpServlet {

	private static final long serialVersionUID = -407738805277662420L;
	private static final Logger LOG = Logger.getLogger(DeleteMealController.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Parser.parseId(req.getParameter(RequestParam.ID));

			boolean isDeleted = MealService.delete(id);

			if (isDeleted) {
				LOG.info("meal deleted");
				ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.DELETE_SUCCEFULLY);
			} else {
				LOG.warn("meal not deleted");
				ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.DELETE_ERROR);
			}
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.DELETE_ERROR);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.UNKNOWN_EXCEPTION);
		}
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}
