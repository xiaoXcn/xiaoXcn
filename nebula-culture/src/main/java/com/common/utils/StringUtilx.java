package com.common.utils;

public class StringUtilx {

	/**
	 * 判断字符串是否为Null/""/"  ",如果是则返回true,否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(null==str || str.trim()==""){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为Null/"",如果是则返回true,否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(null==str||str.length()==0){
			return true;
		}
		return false;
	}
	
	public static String upperFirstWord(String str){
		if(null!=str && str.length()>0){
			return str.substring(0, 1).toUpperCase()+str.substring(1);
		}
		return str;
	}
	
}
