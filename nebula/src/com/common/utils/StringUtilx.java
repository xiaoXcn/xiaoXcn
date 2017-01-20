package com.common.utils;

/**
 * 
 * @author xiaoXcn 2017-01-20
 *
 */
public class StringUtilx {

	public static String upperFirstWord(String str){
		if(str == null || str.trim() ==""){
			return str;
		}
		String firstWord = str.substring(0, 1).toUpperCase();
		return firstWord+str.substring(1);
		
	}
	
	public static void main(String[] args){
		System.out.println(StringUtilx.upperFirstWord("handler"));
	}
}
