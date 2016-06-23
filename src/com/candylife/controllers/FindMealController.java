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
import com.candylife.exception.SearchEmptyException;
import com.candylife.exception.SearchManyParamException;
import com.candylife.constants.RequestParam;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.CheckUtil;
import com.candylife.util.ControllerUtil;

@WebServlet(name = "FindMealServtet", urlPatterns = "/findMeal")
public class FindMealController extends HttpServlet {

	private static final long serialVersionUID = -2982563367087578687L;
	private static final Logger LOG = Logger.getLogger(FindMealController.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String searchValue = CheckUtil.checkSearchvalue(req.getParameter(RequestParam.SEARCH));
			List<Meal> findResult = MealService.find(searchValue);
			LOG.info("found meals: " + findResult.size());

			if (!findResult.isEmpty()) {
				ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.SEARCH_RESPONSE);
				// req.setAttribute(RequestParam.RESULT_LIST, findResult);
			} else {
				ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.EMPTY_SET);
			}

		} catch (SearchManyParamException e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, ServletConstant.NO, e.getMessage());
		} catch (SearchEmptyException e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(req, ServletConstant.NO, e.getMessage());
		}
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}