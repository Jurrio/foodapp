package ua.com.jurimik.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.model.User;
import ua.com.jurimik.service.UserService;

@WebFilter(filterName = "AuthentificationFilter", servletNames = { "AddMealServlet", "DeleteMealServlet",
		"ListMealServlet" })
public class AuthentificationFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(AuthentificationFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession(false);

		if (session.getAttribute(Parameters.USER) == null) {
			if (session.getAttribute(Parameters.USER_ID) != null) {
				int userId = (int) session.getAttribute(Parameters.USER_ID);
				LOG.debug("User autorized from session. Id: " + userId);
				session.setAttribute(Parameters.USER, new UserService().get(userId));
			} else {
				LOG.warn("Unauthorized user");
				request.setAttribute(Parameters.ERROR, Messages.AUTORIZED_ERROR_ACCESS);

				request.getRequestDispatcher("/login").forward(request, response);
			}
		} else {
			LOG.debug("User is authorized");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
