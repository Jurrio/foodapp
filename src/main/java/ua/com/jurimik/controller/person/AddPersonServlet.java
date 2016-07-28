package ua.com.jurimik.controller.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.jurimik.builder.PersonBuilder;
import ua.com.jurimik.builder.UserBuilder;
import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.exception.EmailFormatException;
import ua.com.jurimik.exception.PasswordLengthException;
import ua.com.jurimik.exception.PasswordsNotEqualException;
import ua.com.jurimik.model.Person;
import ua.com.jurimik.model.User;
import ua.com.jurimik.service.PersonService;
import ua.com.jurimik.util.EmailValidator;
import ua.com.jurimik.util.ParameterConverter;
import ua.com.jurimik.util.PasswordValidator;

@WebServlet(name = "AddPersonServlet", urlPatterns = "/addPerson")
public class AddPersonServlet extends HttpServlet {

	private static final long serialVersionUID = 641673800707374013L;
	private static final Logger LOG = Logger.getLogger(AddPersonServlet.class);

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

		User user = new UserBuilder(email, passwd).chef(isChef).admin(isAdmin).build();
		Person person = new PersonBuilder().user(user).firstName(fName).lastName(lName).build();

		boolean isAdded = new PersonService().add(person);

		if (isAdded) {
			LOG.info("person added");
			request.setAttribute(Parameters.MESSAGE, Messages.ADD_PERSON_SUCCEFULLY);
			request.setAttribute(Parameters.PERSON_ID, person.getId());
			LOG.debug("set attribute " + Parameters.PERSON_ID + ": " + person.getId());
		} else {
			LOG.warn("person not added");
			request.setAttribute(Parameters.ERROR, Messages.ADD_PERSON_ERROR);
		}

		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

}
