package ua.com.jurimik.filter;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import ua.com.jurimik.constant.Parameters;
import ua.com.jurimik.constant.UrlPermissions;
import ua.com.jurimik.enums.Role;
import ua.com.jurimik.model.User;

@WebFilter("*")
public class PermissionFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HashMap<String, Role> rules = UrlPermissions.getRules();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String pageName = httpRequest.getRequestURL().toString();
		User currentUser = (User) httpRequest.getAttribute(Parameters.USER);
		Role role = rules.get(pageName);
		if (currentUser != null && currentUser.getPermissions().hasRole(role)) {
			request.setAttribute(Parameters.ERROR_ACCESS,
					"You havn't access for this page! You need " + role + "'s permissions.");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
