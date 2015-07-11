package com.survey.util;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.survey.service.RightService;

public class ExtractAllRights {

	public static void main(String[] args) {
		try {

			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			RightService rightService = (RightService) ac.getBean("rightService");
			
			ClassLoader loder = ExtractAllRights.class.getClassLoader();
			URL url = loder.getResource("com/survey/struts/action");
			File dir = new File(url.toURI());
			File[] files = dir.listFiles();

			String fileName = "";

			for (File f : files) {
				fileName = f.getName();
				if (fileName.endsWith(".class")
						&& !fileName.equals("BaseAction.class")) {
					processAction(fileName,rightService);
				}
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private static void processAction(String fileName, RightService rightService) {
		try {
			String simpleName = fileName.substring(0,
					fileName.indexOf(".class"));
			String className = "com.survey.struts.action." + simpleName;
			Class clazz = Class.forName(className);
			Method[] methods = clazz.getDeclaredMethods();

			int modify;
			Class returnType;
			Parameter[] params;
			String url;

			for (Method method : methods) {
				modify = method.getModifiers();
				returnType = method.getReturnType();
				params = method.getParameters();
				if (returnType == String.class && Modifier.isPublic(modify)
						&& VaildateUtil.isVaild(params)) {
					if (method.getName().equals("execute")) {
						url = "/" + simpleName;
					} else {
						url = "/" + simpleName + "_" + method.getName();
					}
					rightService.addRight(url);
				}
				
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
