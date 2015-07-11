package com.survey.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.sun.org.apache.regexp.internal.recompile;
import com.survey.model.security.Rights;
import com.survey.service.RightService;

@Component
public class InitRightListener implements ApplicationListener ,ServletContextAware{

	@Resource
	private RightService rightService;
	private ServletContext sc;
	
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		//上下文刷新事件
		if(arg0 instanceof ContextRefreshedEvent){
			List<Rights> rights = rightService.getAllEntities();
			Map<String,Rights> map = new HashMap<String, Rights>();
			for(Rights r : rights){
				map.put(r.getRightUrl(), r);
			}
			
			if(sc != null){
				sc.setAttribute("all rights map", map);
				System.out.println("将所有的rights 放入application 中");
			}
			
		}

	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}

}
