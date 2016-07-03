package main.java.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import main.java.constants.Messages;
import main.java.constants.Parameters;

@WebFilter(filterName = "AuthentificationFilter", servletNames = {"AddMealController", 
		"DeleteMealController", "ListMealController"})
public class AuthentificationFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(AuthentificationFilter.class);
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (httpRequest.getSession().getAttribute(Parameters.USER) == null) {

			LOG.warn("Unauthorized user");
			request.setAttribute(Parameters.MESSAGE, Messages.AUTORIZED_FAIL);
			
			request.getRequestDispatcher("/LoginController").forward(request, response);
		} else {
			LOG.debug("User is authorized");
			chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
