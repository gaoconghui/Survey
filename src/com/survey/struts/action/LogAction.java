package com.survey.struts.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.Log;
import com.survey.service.LogService;

/**
 * 日志处理Action
 */
@Controller
@Scope("prototype")
public class LogAction extends BaseAction<Log> {

	private static final long serialVersionUID = -2025894861269904249L;

	private List<Log> allLog;

	public List<Log> getAllLog() {
		return allLog;
	}

	@Resource
	private LogService logService;

	public String findAllLogs() {
		this.allLog = logService.findNearlestLogs(3);
		return "loglistpage";
	}

}
