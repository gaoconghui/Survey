package com.suvery.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class dataSourceTest {

	
	@Test
	public void testDataSource(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) applicationContext.getBean("datasource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
}
