package com.survey.service;

import java.util.List;

import com.survey.model.Log;

public interface LogService extends BaseService<Log>{

	/**
	 * 通过表名创建日志表
	 */
	public void createLogTabe(String tableName);
	
	/**
	 * 查询最近n个月的日志
	 */
	public List<Log> findNearlestLogs(int n );
		

}
