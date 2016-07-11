package ua.com.jurimik.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ua.com.jurimik.constant.Parameters;

public class ControllerUtil {

	private static final Logger LOG = Logger.getLogger(ControllerUtil.class);

	public static void setAttributes(HttpServletRequest req, String success, String message) {
		req.setAttribute(Parameters.SUCCESS, success);
		req.setAttribute(Parameters.MESSAGE, message);
		LOG.debug("Set message: " + message + ", success: " + success);
	}
}