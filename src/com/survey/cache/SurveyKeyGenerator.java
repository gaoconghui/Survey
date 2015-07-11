package com.survey.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

import com.survey.util.StringUtil;

public class SurveyKeyGenerator implements KeyGenerator{

	@Override
	public Object generate(Object arg0, Method arg1, Object... arg2) {
		String className = arg0.getClass().getSimpleName();
		String methodName = arg1.getName();
		String params = StringUtil.arr2Str(arg2);
		String key = className + "." + methodName +"("+ params +")" ;
		System.out.println(key);
		return key;
	}

}
