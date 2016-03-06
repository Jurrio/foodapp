package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.service.MealService;

@WebServlet ("/addMeal")
public class AddMeal extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String type = req.getParameter("type");
		String available = req.getParameter("available");
		String price = req.getParameter("price");
		String owner = req.getParameter("owner");
		String time = req.getParameter("time");
		
		MealService.add(title, description, type, available, price, owner, time);
		
	}	
}
