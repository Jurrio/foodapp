package com.candylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.ServletConstant;
import com.candylife.constants.RequestParam;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;
import com.candylife.util.Parser;

@WebServlet(name = "DeleteMealServlet", urlPatterns = "/deleteMeal")
public class DeleteMealController extends HttpServlet {

	private static final long serialVersionUID = -407738805277662420L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
		ControllerUtil.setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		disp.forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("dashboard.jsp");
			
		try {
			int id = Parser.parseId(req.getParameter(RequestParam.ID));
		
			boolean isDeleted = MealService.delete(id);
			
			if (isDeleted) {
				ControllerUtil.setAttributes(req, ServletConstant.YES, ServletConstant.DELETE_SUCCEFULLY);
				disp.forward(req, resp);
			} else {
				ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.DELETE_ERROR);
				disp.forward(req, resp);
			}
		} catch (NumberFormatException e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.DELETE_ERROR);
			disp.forward(req, resp);
		} catch (Exception e) {
			ControllerUtil.setAttributes(req, ServletConstant.NO, ServletConstant.UNKNOWN_EXCEPTION);
			disp.forward(req, resp);
		}
	}
}
