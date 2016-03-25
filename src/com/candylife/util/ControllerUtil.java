package com.candylife.util;

import javax.servlet.http.HttpServletRequest;

import com.candylife.constants.RequestParam;

public class ControllerUtil {
	public static void setAttributes(HttpServletRequest req, String attrOne, String attrTwo) {
		req.setAttribute(RequestParam.SUCCESS, attrOne);
		req.setAttribute(RequestParam.MESSAGE, attrTwo);
	}
}
