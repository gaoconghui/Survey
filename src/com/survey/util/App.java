package com.survey.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App {

	public static void main(String[] args) throws Exception {
		
		StringBuffer buffer = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String src = "abc";
		byte[] bytes = src.getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] targ = md.digest(bytes);
		
		for(byte b : targ){
			buffer.append(chars[ (b>>4) &0x0F]);
			buffer.append(chars[ b &0x0F]);
		}
		
	}
	
	public static Object deeplyCopy(Serializable src){
		try {
			ByteArrayOutputStream outByte = new ByteArrayOutputStream();
			ObjectOutput out = new ObjectOutputStream(outByte);
			out.writeObject(src);
			out.close();
			outByte.close();
			
			byte[] bytes = outByte.toByteArray();
			ByteArrayInputStream inByte = new ByteArrayInputStream(bytes);
			ObjectInput in = new ObjectInputStream(inByte);
			Serializable serializable = (Serializable) in.readObject();
			in.close();
			inByte.close();
			return serializable;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
