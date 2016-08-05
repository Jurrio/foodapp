package ua.com.jurimik.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.model.User;
import ua.com.jurimik.service.UserService;
import ua.com.jurimik.util.ParameterConverter;

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/registration")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 641673800707374013L;
	private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("redirect to registration.jsp");
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fName = request.getParameter(Parameters.FIRST_NAME);
		String lName = request.getParameter(Parameters.LAST_NAME);
		String email = request.getParameter(Parameters.EMAIL);
		String passwd = request.getParameter(Parameters.PASSWORD);
		boolean isChef = ParameterConverter.convertBoolean(request.getParameter(Parameters.IS_CHEF));
		boolean isAdmin = ParameterConverter.convertBoolean(request.getParameter(Parameters.IS_ADMIN));

		User usr = new UserBuilder().email(email).password(passwd).firstName(fName).lastName(lName).chef(isChef)
				.admin(isAdmin).build();

		boolean isAdded = new UserService().add(usr);

		if (isAdded) {
			LOG.info("user added");
			request.setAttribute(Parameters.MESSAGE, Messages.ADD_USER_SUCCEFULLY);
			request.setAttribute(Parameters.USER_ID, usr.getId());
			LOG.debug("set attribute " + Parameters.USER_ID + ": " + usr.getId());
			response.sendRedirect("homePage");
		} else {
			LOG.warn("user not added");
			request.setAttribute(Parameters.ERROR, Messages.ADD_USER_ERROR);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
	}

}
