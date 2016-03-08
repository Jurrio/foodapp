package com.candylife.util;

public class ControllerUtil {
	public static String checkParam(String param, String noParam) {
		if (param.trim() != null) return param;
		return noParam;
	}
}
