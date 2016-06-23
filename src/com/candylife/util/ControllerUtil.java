package com.candylife.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.candylife.constants.RequestParam;

public class ControllerUtil {

	private static final Logger LOG = Logger.getLogger(ControllerUtil.class.getName());

	public static void setAttributes(HttpServletRequest req, String success, String message) {
		req.setAttribute(RequestParam.SUCCESS, success);
		req.setAttribute(RequestParam.MESSAGE, message);
		LOG.debug("Set message: " + message + ", success: " + success);
	}
}