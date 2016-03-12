package com.candylife.util;

public class ControllerUtil {
	public static String checkParam(String param, String noParam) {
		if (param.trim() != null) return param;
		return noParam;
	}
	
	public static boolean checkParam(String param) {
		return param != null;
	}

	public static String checkId(String id, String noId) {
		try {
			int casteId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return noId;
		} 
		return id;
	}

	public static double checkParam(String parameter, double noPrice) {
		double d;
		try {
			d = Double.parseDouble(parameter);
		} catch(NumberFormatException ex) {
			d = 0.0;
		}
		return d;
	}
}
