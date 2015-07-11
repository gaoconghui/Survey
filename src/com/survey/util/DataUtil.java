package com.survey.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.survey.model.BaseEntity;
import com.survey.model.security.Rights;

/*
 * 数据工具类
 */
public class DataUtil {

	/**
	 * md5 算法进行加密
	 * @param src
	 * @return
	 */
	public static String md5(String src){
		StringBuffer buffer = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		byte[] bytes = src.getBytes();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] targ = md.digest(bytes);
			
			for(byte b : targ){
				buffer.append(chars[ (b>>4) &0x0F]);
				buffer.append(chars[ b &0x0F]);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将id 抽取出来组成字符串
	 */
	public static String extractIds(List<? extends BaseEntity> entities) {
		String str = "";
		for(BaseEntity baseEntity : entities){
			str = str + baseEntity.getId() +"," ;
		}
		return str.substring(0, str.length()-1);
	}
}
