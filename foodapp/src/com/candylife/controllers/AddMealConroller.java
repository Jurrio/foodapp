package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.WebPage;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.ControllerUtil;
import com.candylife.util.MealBuilder;

@WebServlet (name = "AddMMealServlet", urlPatterns = "/addMeal")
public class AddMealConroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Maybe ControllerUtil.checkParam should be called from Service layer?
		
		String title = ControllerUtil.checkParam(req.getParameter(WebPage.TITLE), WebPage.NO_TITLE);
		String description = ControllerUtil.checkParam(req.getParameter(WebPage.DESCRIPTION), WebPage.NO_DESCRIPTION);
		String type = ControllerUtil.checkParam(req.getParameter(WebPage.TYPE), WebPage.NO_TYPE);
		boolean available = ControllerUtil.checkParam(req.getParameter(WebPage.AVAILABLE));
		double price = ControllerUtil.checkParam(req.getParameter(WebPage.PRICE), WebPage.NO_PRICE);
		String owner = ControllerUtil.checkParam(req.getParameter(WebPage.OWNER), WebPage.NO_OWNER);
		
		Meal meal = new Meal(new MealBuilder(title, type, price).available(available).owner(owner).description(description));
		
		//String isAdd = MealService.add(title, description, type, available, price, owner);
		
		PrintWriter out = resp.getWriter();
		
		//out.println(isAdd);
		
//		if (isAdd) {
//			//Constant Done!
//			out.println(Servlet.ADD_SUCSEFULLY);
//			
//			//Util class to convert to html
//			out.println("type: " + type + "title: " + title + "\ndescription: " + description + "\navailable: " + available + 
//					"\nprice: " + price + "\nowner: " + owner + "\ntime: " + time);
//		} else {
//			//constant Done!
//			out.println(Servlet.ADD_ERROR); //TODO: add error message
//		}
	}	
}
