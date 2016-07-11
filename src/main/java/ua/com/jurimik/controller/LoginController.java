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
import ua.com.jurimik.service.PersonService;
import ua.com.jurimik.util.ControllerUtil;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControllerUtil.setAttributes(request, Messages.VOID, Messages.VOID);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int time = 2 * 60 * 60;

		String login = request.getParameter(Parameters.EMAIL);
		String password = request.getParameter(Parameters.PASSWORD);

		boolean isAutorized = PersonService.login(login, password);

		if (isAutorized) {
			LOG.debug("User autorized");
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute(Parameters.USER, login);
			httpSession.setMaxInactiveInterval(time);
			Cookie userName = new Cookie(Parameters.USER, login);
			userName.setMaxAge(time);
			httpResponse.addCookie(userName);

			LOG.debug("set livetime for " + login + " " + time);

			request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_OK);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			LOG.debug("User not autorized");
			request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_FAIL);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
