package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.Servlet;
import com.candylife.constants.Fields;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;
import com.candylife.util.MealBuilder;
import com.candylife.util.OutUtil;

@WebServlet (name = "AddMMealServlet", urlPatterns = "/addMeal")
public class AddMealConroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String title = ControllerUtil.checkParam(req.getParameter(Fields.TITLE), Fields.NO_TITLE);
//		String description = ControllerUtil.checkParam(req.getParameter(Fields.DESCRIPTION), Fields.NO_DESCRIPTION);
		String type = ControllerUtil.checkParam(req.getParameter(Fields.TYPE), Fields.NO_TYPE);
		boolean available = ControllerUtil.checkParam(req.getParameter(Fields.AVAILABLE));
		double price = ControllerUtil.checkParam(req.getParameter(Fields.PRICE), Fields.NO_PRICE);
		String owner = ControllerUtil.checkParam(req.getParameter(Fields.OWNER), Fields.NO_OWNER);
		
		Meal meal = new Meal(new MealBuilder(title, type, price).available(available).owner(owner).description(Fields.NO_DESCRIPTION));
		
		boolean isAdd = MealService.add(meal);
		
		PrintWriter out = resp.getWriter();
		
		if (isAdd) {
			out.println(OutUtil.printMeal(meal));
		} else {
			out.println(Servlet.ADD_ERROR); //TODO: add error message
		}
	}	
}
