package com.survey.util;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Dictionary;

/**
 * 日志工具类
 */
public class LogUtil {
	
	/**
	 * 生成日志表名称 ： logs_2015_7
	 * offset:偏移量
	 */
	public static String generateLogTableName(int offset){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1 + offset;
		
		if(month > 12){
			year ++ ;
			month = month - 12;
		}
		
		if(month < 1){
			year -- ;
			month = month + 12;
		}
		DecimalFormat df = new DecimalFormat("00");
		
		return "logs_"+year+"_"+df.format(month);
	}
	
}
