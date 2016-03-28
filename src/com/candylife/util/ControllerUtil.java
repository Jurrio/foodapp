package com.candylife.util;

import javax.servlet.http.HttpServletRequest;

import com.candylife.constants.RequestParam;

public class ControllerUtil {
	public static void setAttributes(HttpServletRequest req, String success, String message) {
		req.setAttribute(RequestParam.SUCCESS, success);
		req.setAttribute(RequestParam.MESSAGE, message);
	}
}
