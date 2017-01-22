package com.common.utils;

import java.util.UUID;

public class IDUtilx {

	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
}
