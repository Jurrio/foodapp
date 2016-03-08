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
import com.sun.corba.se.impl.orbutil.closure.Constant;

@WebServlet ("/addMeal")
public class AddMealConroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = ControllerUtil.checkParam(req.getParameter(WebPage.TITLE), WebPage.NO_TITLE);
		String description = ControllerUtil.checkParam(req.getParameter(WebPage.DESCRIPTION), WebPage.NO_DESCRIPTION);
		String type = ControllerUtil.checkParam(req.getParameter(WebPage.TYPE), WebPage.NO_TYPE);
		String available = req.getParameter(WebPage.AVAILABLE);
		String price = ControllerUtil.checkParam(req.getParameter(WebPage.PRICE), WebPage.NO_PRICE);
		String owner = ControllerUtil.checkParam(req.getParameter(WebPage.OWNER), WebPage.NO_OWNER);
		String time = ControllerUtil.checkParam(req.getParameter(WebPage.TIME), WebPage.NO_TIME);
		
		boolean isAdd = MealService.add(title, description, type, available, price, owner, time);
		
		PrintWriter out = resp.getWriter();
		
		if (isAdd) {
			out.println("Meal addes sucsessfully!");
			out.println("type: " + type + "title: " + title + "\ndescription: " + description + "\navailable: " + available + 
					"\nprice: " + price + "\nowner: " + owner + "\ntime: " + time);
		} else {
			out.println("Error"); //TODO: add error message
		}
	}	
}
