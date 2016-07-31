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

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.exception.EmailFormatException;
import ua.com.jurimik.util.EmailValidator;

@WebFilter(filterName = "EmailFilter", servletNames = "AddPersonServlet")
public class EmailFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(EmailFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
			String email = request.getParameter(Parameters.EMAIL);

			try {
				if (!EmailValidator.validate(email)) {
					request.setAttribute(Parameters.ERROR_EMAIL, Messages.ERROR_EMAIL);
					LOG.info("email not validate");
				}
			} catch (EmailFormatException e) {
				request.setAttribute(Parameters.ERROR_EMAIL, e.getMessage());
				LOG.info(e.getMessage());
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
