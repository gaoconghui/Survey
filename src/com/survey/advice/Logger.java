package com.survey.advice;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;

import com.opensymphony.xwork2.ActionContext;
import com.survey.model.Log;
import com.survey.model.User;
import com.survey.service.LogService;
import com.survey.util.StringUtil;

/**
 * Logger
 */
public class Logger {
	
	@Resource
	private LogService logService ;
	/**
	 * 记录
	 */
	public Object record(ProceedingJoinPoint pjp) {
		Log log = new Log();
		try {
			ActionContext ac = ActionContext.getContext();
			// 设置操作人
			if (ac != null) {
				Map<String, Object> session = ac.getSession();
				if (session != null) {
					User user = (User) session.get("user");
					if (user != null) {
						log.setOperator("" + user.getId() + ":"
								+ user.getName());
					}
				}
			}
			// 操作名称
			log.setOperName(pjp.getSignature().getName());
			// 操作参数
			log.setOperParams(StringUtil.arr2Str(pjp.getArgs()));
			// 调用目标的对象方法
			Object ret = pjp.proceed();
			// 设置操作结果
			log.setOperResult("success");
			if (ret != null) {
				log.setResultMsg(ret.toString());
			}
			return ret ; 
		} catch (Throwable e) {
			log.setOperResult("failure");
			log.setResultMsg(e.getMessage());
		}finally{
			logService.saveEntity(log);
		}

		return null;
	}

}
