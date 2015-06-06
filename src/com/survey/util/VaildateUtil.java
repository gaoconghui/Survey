package com.survey.util;

import java.util.Collection;

/**
 * 校验工具类
 * @author apple
 *
 */
public class VaildateUtil {

	/**
	 * 检验是否有效
	 * @param src
	 */
	public static boolean isVaild(String src){
		return !(src==null || src.trim().equals(""));
	}
	public static boolean isVaild(Collection collection){
		return !(collection==null || collection.isEmpty());
	}
	
}
