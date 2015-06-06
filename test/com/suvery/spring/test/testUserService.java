package com.suvery.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.survey.dao.impl.UserDaoImpl;
import com.survey.model.User;
import com.survey.service.UserService;
import com.survey.service.impl.UserServiceImpl;

public class testUserService {

//	private static UserServiceImpl userService ;
	private static UserService userService ;
	private static UserDaoImpl userDaoImpl ;
	
	
	@BeforeClass
	public static void iniUserService(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (UserServiceImpl) applicationContext.getBean("userService");
		userService =  (UserService) applicationContext.getBean("userService");
		userDaoImpl = (UserDaoImpl) applicationContext.getBean("userDao");
	}
	
	@Test
	public void testUserService1(){
		User user = new User(); 
		user.setName("a");
		userService.saveEntity(user);
		System.out.println(userService);
	}
	
	@Test
	public void testUserDao(){
		User user = new User();
		user.setName("a");
		System.out.println(userDaoImpl);
	}
	
	@Test
	public void testLogin(){
		System.out.println(userService.validateLogin("381147882@qq.com", "E10ADC3949BA59ABBE56E057F20F883E"));;
//		System.out.println(userService);
	}
}
