package ua.com.jurimik.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.model.User;
import ua.com.jurimik.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int time = 2 * 60 * 60;

		String email = request.getParameter(Parameters.EMAIL);
		String password = request.getParameter(Parameters.PASSWORD);
//		boolean isRemember = ParameterConverter.convertBoolean(Parameters.REMEMBER);

		int autorized = new UserService().login(email, password);

		if (autorized > 0) {
			LOG.debug("User autorized");
			User user = new UserService().get(email, password);

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(Parameters.USER, user);
			httpSession.setMaxInactiveInterval(time);

			request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_OK);
			response.sendRedirect("homePage");
		} else {
			LOG.debug("User not autorized");
			request.setAttribute(Parameters.ERROR, Messages.AUTORIZED_FAIL);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}
}
