package ua.com.jurimik.controller.person;

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
import ua.com.jurimik.service.PersonService;
import ua.com.jurimik.util.ParameterConverter;

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/registration")
public class RegisterUserServlet extends HttpServlet {

	private static final long serialVersionUID = 641673800707374013L;
	private static final Logger LOG = Logger.getLogger(RegisterUserServlet.class);

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

		User person = new UserBuilder().email(email).password(passwd).firstName(fName).lastName(lName).chef(isChef)
				.admin(isAdmin).build();

		boolean isAdded = new PersonService().add(person);

		if (isAdded) {
			LOG.info("person added");
			request.setAttribute(Parameters.MESSAGE, Messages.ADD_PERSON_SUCCEFULLY);
			request.setAttribute(Parameters.PERSON_ID, person.getId());
			LOG.debug("set attribute " + Parameters.PERSON_ID + ": " + person.getId());
			request.getRequestDispatcher("reg-success.jsp").forward(request, response);
		} else {
			LOG.warn("person not added");
			request.setAttribute(Parameters.ERROR, Messages.ADD_PERSON_ERROR);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
	}

}
