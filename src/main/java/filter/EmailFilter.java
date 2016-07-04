package main.java.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

import main.java.constant.Parameters;
import main.java.exception.EmailFormatException;
import main.java.util.EmailChecker;

/**
 * Servlet Filter implementation class RegistrationFilter
 */
@WebFilter(filterName = "EmailFilter", servletNames = "AddPersonServlet")
public class EmailFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(EmailFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String email = request.getParameter(Parameters.EMAIL);
		
		try {
			if (EmailChecker.checkWithRegExp(email)) {
				LOG.info("eamil is OK");
			}
		} catch (EmailFormatException e) {
			request.setAttribute(Parameters.MESSAGE, e.getMessage());
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
