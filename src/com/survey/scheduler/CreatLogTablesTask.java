package com.survey.scheduler;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.survey.service.LogService;
import com.survey.util.LogUtil;

public class CreatLogTablesTask extends QuartzJobBean {

	@Resource
	private LogService logService;

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	/**
	 * 生成日志表
	 */
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("调用了");
		
		// 下一月
		String tableName = LogUtil.generateLogTableName(1);
		logService.createLogTabe(tableName);
		
		// 下二月
		tableName = LogUtil.generateLogTableName(2);
		logService.createLogTabe(tableName);
		
		// 下三月
		tableName = LogUtil.generateLogTableName(3);
		logService.createLogTabe(tableName);
	}

}
