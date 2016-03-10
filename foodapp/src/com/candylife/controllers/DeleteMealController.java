package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.WebPage;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;

@WebServlet("/deleteMeal")
public class DeleteMealController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Maybe ControllerUtil.checkParam should be called from Service layer?
		
		//Does this even work? Where do you get parameter from request?
		
		String id = ControllerUtil.checkId(req.getParameter(WebPage.ID), WebPage.NO_ID);
		
		String result = MealService.delete(id);
		
		PrintWriter out = resp.getWriter();
		out.println(result);
	}

}
