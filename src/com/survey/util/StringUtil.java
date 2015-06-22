package com.survey.util;

public class StringUtil {

	public static String[] str2arr(String str,String rex){
		if(VaildateUtil.isVaild(str)){
			System.out.println(str.split(rex)[0]);
			return str.split(rex);
		}else{
			return null;
		}
	}
}
