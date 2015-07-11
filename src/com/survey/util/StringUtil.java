package com.survey.util;

public class StringUtil {

	public static String[] str2arr(String str, String rex) {
		if (VaildateUtil.isVaild(str)) {
			return str.split(rex);
		} else {
			return null;
		}
	}

	public static boolean contains(String[] values, String value) {
		if (values != null && values.length > 0) {
			for (String s : values) {
				if (s.equals(value))
					return true;
			}
		}
		return false;
	}

	public static String arr2Str(Object[] value) {
		String strValue = "";
		if(value !=null && value.length>0){
			for(Object obj : value){
				strValue = strValue.concat(obj.toString()).concat(",");
			}
			return strValue.substring(0,strValue.length()-1);
		}
		return "";
	}
	
	public static String arr2Str(String[] value) {
		String strValue = "";
		if(value !=null && value.length>0){
			for(String str : value){
				strValue = strValue.concat(str).concat(",");
			}
			return strValue.substring(0,strValue.length()-1);
		}
		return "";
	}

	public static String arr2Str(Integer[] value) {
		String strValue = "";
		if(value !=null && value.length>0){
			for(Integer str : value){
				strValue = strValue.concat(str+"").concat(",");
			}
			return strValue.substring(0,strValue.length()-1);
		}
		return "";
	}
	
	public static String getDescString(String str){
		if(str.length() < 30)
			return str;
		return str.substring(0, 30);
	}
}
