package main.java.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import main.java.constants.Parameters;

public class ControllerUtil {

	private static final Logger LOG = Logger.getLogger(ControllerUtil.class.getName());

	public static void setAttributes(HttpServletRequest req, String success, String message) {
		req.setAttribute(Parameters.SUCCESS, success);
		req.setAttribute(Parameters.MESSAGE, message);
		LOG.debug("Set message: " + message + ", success: " + success);
	}
}