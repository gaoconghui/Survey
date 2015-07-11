package com.survey.datasource;

import com.survey.model.Survey;

/**
 * 令牌，实现消息传递
 */
public class SurveyToken {

	private static ThreadLocal<SurveyToken> threadLocal = new ThreadLocal<SurveyToken>();
	
	private Survey survey;
	
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public Survey getSurvey() {
		return survey;
	}
	
	/**
	 * 将指定的令牌对象绑定到当前线程
	 */
	public static void bindToken(SurveyToken surveyToken){
		threadLocal.set(surveyToken);
	}
	
	/**
	 * 解除当前线程绑定的令牌 
	 */
	public static void unbindToken(){
		threadLocal.remove();
	}
	
	public static SurveyToken getCurrentToken(){
		return threadLocal.get();
	}
}
