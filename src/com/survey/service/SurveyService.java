package com.survey.service;

import java.util.List;

import com.survey.model.Page;
import com.survey.model.Question;
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

	public Survey getServeyByIdWithChild(Integer sid);

	public void updateSurvey(Survey model);

	public void saveOrUpdatePage(Page model);

	public Page getPageById(Integer pid);

	public void saveOrUpdateQuestion(Question model);

	public void deleteQuestion(Integer qid);

	/*
	 * 删除页面
	 */
	public void deletePage(Integer pid);

	/*
	 * 删除调查
	 */
	public void deleteSurvey(Integer sid);

	/*
	 * 查询问题
	 */
	public Question getQuestion(Integer qid);


}
