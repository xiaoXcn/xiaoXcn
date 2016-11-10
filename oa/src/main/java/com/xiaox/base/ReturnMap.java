package com.xiaox.base;

import java.util.HashMap;
import java.util.Map;

public class ReturnMap {

	public static Map<String,Object> assembleReturnMap(String result,String desc){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("result", result);
		returnMap.put("desc", desc);
		return returnMap;
	}
	
	public static Map<String,Object> addReturnParam(Map<String,Object> returnMap,String key,Object object){
		returnMap.put(key, object);
		return returnMap;
	}
}
