package main.java.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.constants.Messages;
import main.java.constants.Parameters;
import main.java.exception.EmailFormatException;
import main.java.service.PersonService;
import main.java.util.ControllerUtil;
import main.java.util.EmailChecker;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControllerUtil.setAttributes(request, Messages.VOID, Messages.VOID);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String login = request.getParameter(Parameters.EMAIL);
			String password = request.getParameter(Parameters.PASSWORD);

			if (EmailChecker.checkWithRegExp(login)) { // else throw EmailFormatException
				LOG.debug("Email is OK!");
			}
			boolean isAutorized = PersonService.get(login, password);

			if (isAutorized) {
				LOG.debug("User autorized");
				request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_OK);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				LOG.debug("User autorized");
				request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_FAIL);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (EmailFormatException e) {
			LOG.error(e.getMessage());
			ControllerUtil.setAttributes(request, Messages.NO, e.getMessage());
		}

		/*
		 * if (PersonService.login(login, password)) {
		 * response.sendRedirect("homePage"); } else doGet(request, response);
		 */ }

}
