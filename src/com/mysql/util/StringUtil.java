package com.mysql.util;

public class StringUtil {
	public static boolean isEmpty(String username) {
		if (username == null || username.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
