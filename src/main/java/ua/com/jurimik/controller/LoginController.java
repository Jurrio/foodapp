package ua.com.jurimik.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.model.User;
import ua.com.jurimik.service.PersonService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int time = 2 * 60 * 60;

		String login = request.getParameter(Parameters.EMAIL);
		String password = request.getParameter(Parameters.PASSWORD);

		int autorized = new PersonService().login(login, password);

		if (autorized > 0) {
			LOG.debug("User autorized");
			User person = new PersonService().get(login, password);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute(Parameters.USER, person);
			httpSession.setMaxInactiveInterval(time);
			Cookie userName = new Cookie(Parameters.USER, login);
			userName.setMaxAge(time);
			httpResponse.addCookie(userName);

			LOG.debug("set livetime for " + login + " " + time);

			request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_OK);
			request.getRequestDispatcher("log-success.jsp").forward(request, response);
		} else {
			LOG.debug("User not autorized");
			request.setAttribute(Parameters.ERROR, Messages.AUTORIZED_FAIL);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
