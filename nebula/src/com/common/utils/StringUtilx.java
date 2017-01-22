package com.common.utils;

/**
 * 
 * @author xiaoXcn 2017-01-20
 *
 */
public class StringUtilx {

	/**
	 * 将字符串的第一个字母转为大写
	 * @param str
	 * @return
	 */
	public static String upperFirstWord(String str){
		if(str == null || str.trim() ==""){
			return str;
		}
		String firstWord = str.substring(0, 1).toUpperCase();
		return firstWord+str.substring(1);
		
	}
	
	public static Boolean isBlank(String str){
		if(str==null||str.trim()==""){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	public static void main(String[] args){
		System.out.println(StringUtilx.upperFirstWord("handler"));
	}
}
