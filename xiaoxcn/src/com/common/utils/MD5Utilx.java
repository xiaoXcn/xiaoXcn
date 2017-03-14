package com.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utilx {

	/**
	 * MD5加密
	 * @param plainText
	 * @return
	 */
	public static String toMD5(String plainText){
		if(null==plainText || plainText.length()<1){
			return plainText;
		}else{
			MessageDigest messageDigest = null;
			try {
				messageDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("MD5 error:", e);
			}
			messageDigest.update(plainText.getBytes());
			byte by[] = messageDigest.digest();

			StringBuffer buf = new StringBuffer();
			int val;
			for (int i = 0; i < by.length; i++) {
				val = by[i];
				if (val < 0) {
					val += 256;
				} else if (val < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(val));
			}
			return buf.toString().toUpperCase();
		}
	}
}
