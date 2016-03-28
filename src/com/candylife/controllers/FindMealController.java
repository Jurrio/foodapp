package com.candylife.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candylife.constants.ServletConstant;
import com.candylife.exception.SearchEmptyException;
import com.candylife.exception.SearchManyParamException;
import com.candylife.builder.MessageBuilder;
import com.candylife.constants.RequestParam;
import com.candylife.model.Meal;
import com.candylife.service.MealService;
import com.candylife.util.CheckUtil;

@WebServlet(name = "FindMealServtet", urlPatterns = "/findMeal")
public class FindMealController extends HttpServlet {

	private static final long serialVersionUID = -2982563367087578687L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		try {
			String searchValue = CheckUtil.checkSearchvalue(RequestParam.SEARCH);
			List<Meal> findResult = MealService.find(searchValue);
			
			if (!findResult.isEmpty()) {
//				out.println(MessageBuilder.buildStringFromList(findResult));
			} else {
//				out.println(ServletConstant.EMPTY_SET);
			}

		} catch (SearchManyParamException e) {
//			out.println(e.getMessage());
		} catch (SearchEmptyException e) {
//			out.println(e.getMessage());
		}
		
	}
}
