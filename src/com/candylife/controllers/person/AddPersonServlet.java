package com.candylife.controllers.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.candylife.constants.Parameters;
import com.candylife.exception.PasswordsNotEqualException;
import com.candylife.model.Person;
import com.candylife.model.User;
import com.candylife.service.PersonService;
import com.candylife.builder.PersonBuilder;
import com.candylife.builder.UserBuilder;
import com.candylife.constants.Messages;
import com.candylife.util.ControllerUtil;
import com.candylife.util.Parser;

@WebServlet(name = "AddPersonServlet", urlPatterns = "/addPerson")
public class AddPersonServlet extends HttpServlet {

	private static final long serialVersionUID = 641673800707374013L;
	private static final Logger LOG = Logger.getLogger(AddPersonServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControllerUtil.setAttributes(request, Messages.VOID, Messages.VOID);
		LOG.debug("redirect to registration.jsp");
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fName = request.getParameter(Parameters.FIRST_NAME);
			String lName = request.getParameter(Parameters.LAST_NAME);
			String email = request.getParameter(Parameters.EMAIL);
			String passwd = request.getParameter(Parameters.PASSWORD);
			String repeat = request.getParameter(Parameters.REPEAT_PASSWORD);
			boolean isChef = Parser.parseAvailable(request.getParameter(Parameters.IS_CHEF));
			
			if (!passwd.equals(repeat)) { //TODO: filters will be here
				throw new PasswordsNotEqualException();
			}
			
			User user = new UserBuilder(email, passwd).chef(isChef).build(); 
			Person person = new PersonBuilder().user(user).firstName(fName).lastName(lName).build();
			
			boolean isAdded = PersonService.add(person);
			
			if (isAdded) {
				LOG.info("meal added");
				ControllerUtil.setAttributes(request, Messages.YES, Messages.ADD_SUCCEFULLY);
				request.setAttribute(Parameters.PERSON_ID, person.getId());
				LOG.debug("set attribute " + Parameters.MEAL_ID + ": " + person.getId());
			} else {
				LOG.warn("meal not added");
				ControllerUtil.setAttributes(request, Messages.NO, Messages.ADD_ERROR);
			}

		} catch (PasswordsNotEqualException pne) {
			LOG.error(pne.getMessage());
			ControllerUtil.setAttributes(request, Messages.NO, pne.getMessage());
		}
	}

}
