package com.dulp.xyz.common.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.util.Date;

public class MD5Utils {

	/**
	 * @Description: 对字符串进行md5加密
	 */
	public static String getMD5Str(String strValue) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
		return newstr;
	}

	public static void main(String[] args) {
		try {
			String md5 = getMD5Str("imooc");
			System.out.println(md5);
			Date date = new Date();
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
