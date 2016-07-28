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

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.exception.PasswordLengthException;
import ua.com.jurimik.exception.PasswordsNotEqualException;
import ua.com.jurimik.util.PasswordChecker;

@WebFilter(filterName = "PasswordFilter", servletNames = "AddPersonServlet")
public class PasswordFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(PasswordFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
			String passwd = request.getParameter(Parameters.PASSWORD);
			String repeat = request.getParameter(Parameters.REPEAT_PASSWORD);

			try {
				if (!PasswordChecker.checkPasswords(passwd, repeat)) {
					
				}
			} catch (PasswordLengthException e) {
				request.setAttribute(Parameters.ERROR_PASSWORD, e.getMessage());
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			} catch (PasswordsNotEqualException e) {
				request.setAttribute(Parameters.ERROR_REPEAT, e.getMessage());
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
