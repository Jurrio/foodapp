package ua.com.jurimik.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.jurimik.constant.Parameters;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession();
		httpSession.setAttribute(Parameters.USER, null);
		
		for (Cookie cookie : cookies) {
			cookie.setValue(null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);

		}
		HttpSession session = request.getSession();
		session.setAttribute(Parameters.USER, null);
		session.invalidate();
		request.getRequestDispatcher("logout-confirm.jsp").forward(request, response);
	}

}
