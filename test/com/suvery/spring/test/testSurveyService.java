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
import com.survey.service.SurveyService;
import com.survey.service.UserService;
import com.survey.service.impl.UserServiceImpl;

public class testSurveyService {

	private static SurveyService surveyService ;
	
	
	@BeforeClass
	public static void iniUserService(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		surveyService = (SurveyService) applicationContext.getBean("surveyService");
	}
	
	@Test
	public void testSaveSurvey(){
		User user = new User();
		user.setId(4);
		
		surveyService.newSurvey(user);
		
	}
	
}
