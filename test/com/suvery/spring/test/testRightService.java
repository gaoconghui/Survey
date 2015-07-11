package com.suvery.spring.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.survey.dao.BaseDao;
import com.survey.model.User;
import com.survey.model.security.Rights;
import com.survey.model.security.Role;
import com.survey.service.RightService;

public class testRightService {

	private static RightService rightService ;
	private static BaseDao<Rights> rightDao ;
	private static BaseDao<Role> roleDao ;
	private static BaseDao<User> userDao ;
	
	
	@BeforeClass
	public static void iniUserService(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (UserServiceImpl) applicationContext.getBean("userService");
		rightService =  (RightService) applicationContext.getBean("rightService");
		rightDao =  (BaseDao<Rights>) applicationContext.getBean("rightDao");
		userDao =  (BaseDao<User>) applicationContext.getBean("userDao");
		roleDao =  (BaseDao<Role>) applicationContext.getBean("roleDao");
	}
	
	@Test
	public void testGetAll(){
		System.out.println(rightService.getAllEntities());;
//		String hql = "from Right";
//		System.out.println(rightDao.findEntityByHql(hql));
	}
	
	@Test
	public void testSaveRight(){
		Rights model ;
		for(int i = 0 ; i < 10 ; i ++){
			model= new Rights();
			model.setRightName("a");
			rightService.saveOrUpdateRight(model);
			
		}
	}
	
	@Test
	public void testDelete(){
		Rights rights = new Rights();
		rights.setId(144);
		rightService.deleteEntity(rights);
	}
	
	@Test
	public void testUpdate(){
		Rights rights = new Rights();
		rights.setId(194);
		rights.setRightDesc("this is new");
		rightService.saveOrUpdateRight(rights);
	}
	
	@Test
	public void testSaveRole(){
		Role role = new Role();
		role.setRoleDesc("desc");
		role.setRoleName("name");
		role.setRoleValue("value");
		
		roleDao.saveEntity(role);
	}
	
	
	
}
