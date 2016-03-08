package com.candylife.util;

public class ControllerUtil {
	public static String checkParam(String param, String noParam) {
		if (param.trim() != null) return param;
		return noParam;
	}

	public static String checkId(String id, String noId) {
		try {
			int castedId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return noId;
		} 
		return id;
	}
}
