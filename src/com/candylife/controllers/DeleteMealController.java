package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.ServletConstant;
import com.candylife.constants.RequestParam;
import com.candylife.service.MealService;
import com.candylife.util.Parser;

@WebServlet(name = "DeleteMealServlet", urlPatterns = "/deleteMeal")
public class DeleteMealController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("listMeal");
		setAttributes(req, ServletConstant.VOID, ServletConstant.VOID);
		disp.forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("listMeal");
		
		PrintWriter out = resp.getWriter();
		
		try {
			int id = Parser.parseId(req.getParameter(RequestParam.ID));
		
			boolean isDeleted = MealService.delete(id);
			
			if (isDeleted) {
				setAttributes(req, ServletConstant.YES, ServletConstant.DELETE_SUCCEFULLY);
				disp.forward(req, resp);
			} else {
				setAttributes(req, ServletConstant.NO, ServletConstant.DELETE_ERROR);
				disp.forward(req, resp);
			}
		} catch (NumberFormatException e) {
			setAttributes(req, ServletConstant.NO, ServletConstant.DELETE_ERROR);
			disp.forward(req, resp);
		} catch (Exception e) {
			setAttributes(req, ServletConstant.NO, ServletConstant.UNKNOWN_EXCEPTION);
			disp.forward(req, resp);
		}
	}
	
	private void setAttributes(HttpServletRequest req, String attrOne, String attrTwo) {
		req.setAttribute(RequestParam.SUCCESS, attrOne);
		req.setAttribute(RequestParam.MESSAGE, attrTwo);
	}

}
