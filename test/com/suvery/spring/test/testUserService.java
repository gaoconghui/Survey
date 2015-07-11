package com.suvery.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.survey.dao.BaseDao;
import com.survey.dao.impl.UserDaoImpl;
import com.survey.model.Log;
import com.survey.model.User;
import com.survey.service.LogService;
import com.survey.service.UserService;
import com.survey.service.impl.UserServiceImpl;

public class testUserService {

	// private static UserServiceImpl userService ;
	private static UserService userService;
	private static LogService logService;
	private static BaseDao<User> userDao;

	@BeforeClass
	public static void iniUserService() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// userService = (UserServiceImpl)
		// applicationContext.getBean("userService");
		userService = (UserService) applicationContext.getBean("userService");
		logService = (LogService) applicationContext.getBean("logService");
		userDao = (BaseDao<User>) applicationContext.getBean("userDao");
	}

	@Test
	public void testUserService1() {
		User user = new User();
		user.setName("a");
		userService.saveEntity(user);
		System.out.println(userService);
	}

	@Test
	public void testUserDao() {
		User user = new User();
		user.setName("a");
	}

	@Test
	public void testLogin() {
		System.out.println(userService.validateLogin("381147882@qq.com",
				"E10ADC3949BA59ABBE56E057F20F883E"));
		;
		// System.out.println(userService);
	}

	@Test
	public void testGetAll() {
		// System.out.println(userService.getAllEntities());
		String hql = "from User";
		System.out.println(userDao.findEntityByHql(hql));
	}

	@Test
	public void testlOG() {
//		Log log = new Log();
//		log.setOperator("aaa");
//		logService.saveEntity(log);
	User user = new User();
	user.setName("aaaaaates");
	userService.saveEntity(user);
	}
}
