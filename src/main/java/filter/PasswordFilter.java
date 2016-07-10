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
import main.java.exception.PasswordLengthException;
import main.java.exception.PasswordsNotEqualException;
import main.java.util.PasswordChecker;

@WebFilter(filterName = "PasswordFilter", servletNames = "AddPersonServlet")
public class PasswordFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(PasswordFilter.class);
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String passwd = request.getParameter(Parameters.PASSWORD);
		String repeat = request.getParameter(Parameters.REPEAT_PASSWORD);
		
		try {
			if (PasswordChecker.checkPasswords(passwd, repeat)) {
				LOG.info("Password is OK");
			}
		} catch (PasswordLengthException e) {
			request.setAttribute(Parameters.MESSAGE, e.getMessage());
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		} catch (PasswordsNotEqualException e) {
			request.setAttribute(Parameters.MESSAGE, e.getMessage());
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}