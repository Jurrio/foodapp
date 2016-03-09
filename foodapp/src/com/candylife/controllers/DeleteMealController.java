package com.candylife.controllers;

import java.io.IOException;

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
		String id = ControllerUtil.checkId(WebPage.ID, WebPage.NO_ID);
		
		String result = MealService.delete(id);
	}

}
