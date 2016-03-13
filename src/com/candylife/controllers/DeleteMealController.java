package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		PrintWriter out = resp.getWriter();
		
		try {
			int id = Parser.parseId(req.getParameter(RequestParam.ID));
		
			boolean isDeleted = MealService.delete(id);
			
			if (isDeleted) {
				out.println(ServletConstant.DELETE_SUCSEFULLY);
			} else {
				out.println(ServletConstant.DELETE_ERROR);
			}
		} catch (NumberFormatException e) {
			out.println(ServletConstant.DELETE_ERROR);
		} catch (Exception e) {
			out.println(ServletConstant.UNKNOWN_EXCEPTION);
		}
	}

}
