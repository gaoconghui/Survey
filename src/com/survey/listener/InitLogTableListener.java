package com.survey.listener;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.survey.service.LogService;
import com.survey.util.LogUtil;

@Component
public class InitLogTableListener implements ApplicationListener {

	@Resource
	private LogService logService;
	
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		//上下文刷新事件
		if(arg0 instanceof ContextRefreshedEvent){
			logService.createLogTabe(LogUtil.generateLogTableName(0));
			logService.createLogTabe(LogUtil.generateLogTableName(1));
			logService.createLogTabe(LogUtil.generateLogTableName(2));
		}

	}


}
