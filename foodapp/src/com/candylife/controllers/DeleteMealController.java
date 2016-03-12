package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.Servlet;
import com.candylife.constants.WebPage;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;

@WebServlet(name = "DeleteMealServlet", urlPatterns = "/deleteMeal")
public class DeleteMealController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = ControllerUtil.checkId(req.getParameter(WebPage.ID), WebPage.NO_ID);
		
		boolean isDelete = MealService.delete(id);
		
		PrintWriter out = resp.getWriter();
		if (isDelete) {
			out.println(Servlet.DELETE_SUCSEFULLY);
		} else {
			out.println(Servlet.DELETE_ERROR);
		}
	}

}
