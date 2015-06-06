package com.survey.service;

import java.util.List;

import com.survey.model.Survey;
import com.survey.model.User;

public interface SurveyService {

	/*
	 * 获取所有的调查
	 */
	public List<Survey> getAllSurvey(User user);

	/*
	 * 新建调查
	 */
	public Survey newSurvey(User user);

	public Survey getServeyById(Integer sid);

}
