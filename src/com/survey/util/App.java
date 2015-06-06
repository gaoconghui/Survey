package com.survey.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App {

	public static void main(String[] args) throws Exception {
		
		StringBuffer buffer = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String src = "abc";
		byte[] bytes = src.getBytes();
		System.out.println(bytes.length);
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] targ = md.digest(bytes);
		System.out.println(targ.length);
		
		for(byte b : targ){
			buffer.append(chars[ (b>>4) &0x0F]);
			buffer.append(chars[ b &0x0F]);
		}
		System.out.println(buffer);
		
	}
}
