package com.candylife.controllers;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter out = resp.getWriter();
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
		
		try {
			String searchValue = CheckUtil.checkSearchvalue(req.getParameter(RequestParam.SEARCH));
			List<Meal> findResult = MealService.find(searchValue);
			
			if (!findResult.isEmpty()) {
				ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.SEARCH_RESPONSE);
				disp.forward(req, resp);
//				out.println(MessageBuilder.buildStringFromList(findResult));
			} else {
				ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.EMPTY_SET);
				disp.forward(req, resp);
//				out.println(ServletConstant.EMPTY_SET);
			}

		} catch (SearchManyParamException e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, e.getMessage());
			disp.forward(req, resp);
//			out.println(e.getMessage());
		} catch (SearchEmptyException e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, e.getMessage());
			disp.forward(req, resp);
//			out.println(e.getMessage());
		}
	}
}