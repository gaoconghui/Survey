package com.suvery.spring.test;



import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.survey.dao.BaseDao;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.StatisticsService;
import com.survey.service.SurveyService;
import com.survey.service.UserService;
import com.survey.service.impl.UserServiceImpl;

public class testStatisticsService {

	private static StatisticsService statisticsService ;
	
	@Resource
	private static BaseDao<Question> questionDao;
	
	@BeforeClass
	public static void iniUserService(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		statisticsService =  (StatisticsService) applicationContext.getBean("statisticsService");
		questionDao = (BaseDao<Question>) applicationContext.getBean("questionDao");
	}
	
	@Test
	public void testStatistcs(){
//		statisticsService.statistice(10);
		System.out.println("test");
	}
	
	@Test
	public void testHql(){
		String ohql = "select count(*) from Answer a where a.questionId = ? and concat(',',a.answerIds,',') like ?";
		Long ocount = (long) questionDao.uniqueResult(ohql, 11,"%,"+0+",%");
		System.out.println(ocount);
	}
	
}
