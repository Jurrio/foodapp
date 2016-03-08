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
import com.sun.corba.se.impl.orbutil.closure.Constant;

@WebServlet ("/addMeal")
public class AddMealConroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter(WebPage.TITLE) != null ? req.getParameter(WebPage.TITLE) : WebPage.NO_TITLE;
		String description = req.getParameter(WebPage.DESCRIPTION) != null ? req.getParameter(WebPage.DESCRIPTION) : WebPage.NO_DESCRIPTION;
		String type = req.getParameter(WebPage.TYPE) != null ? req.getParameter(WebPage.TYPE) : "";
		String available = req.getParameter(WebPage.AVAILABLE);
		String price = req.getParameter(WebPage.PRICE) != null ? req.getParameter(WebPage.PRICE) : WebPage.NO_PRICE;
		String owner = req.getParameter(WebPage.OWNER) != null ? req.getParameter(WebPage.OWNER) : WebPage.NO_OWNER;
		String time = req.getParameter(WebPage.TIME) != null ? req.getParameter(WebPage.TIME) : WebPage.NO_TIME;
		
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
