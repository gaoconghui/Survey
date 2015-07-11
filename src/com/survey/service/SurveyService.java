package com.survey.service;

import java.util.ArrayList;
import java.util.List;

import com.survey.model.Answer;
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

	/*
	 * 清除一个问卷里的所有回答
	 */
	public void clearSurvey(Integer sid);

	/*
	 * 转换开关
	 */
	public void switchClose(Integer sid);

	/*
	 * 更新logo地址
	 */
	public  void updatePhotoPath(Integer sid, String path);

	/*
	 * 获取所有的调查以及页面
	 */
	public List<Survey> getSurveyWithPage(User user);

	/*
	 * 执行移动或复制操作
	 */
	public void domove(Integer srcpid, Integer tagpid, Integer pos);

	/*
	 * 获取所有的可以参与的调查
	 */
	public List<Survey> getAllOpenSurveys();

	/*
	 * 得到调查问卷的第一页
	 */
	public Page getFirstPage(int sid);

	/*
	 * 返回调查问卷的上一页
	 */
	public Page getPrePage(int currPid);

	/*
	 * 返回下一页的问卷
	 */
	public Page getNextPage(int currPid);

	/*
	 * 保存一组回答
	 */
	public void saveAnswers(ArrayList<Answer> answers);

	/*
	 * 获取全部的问题
	 */
	public List<Question> getQuestions(int sid);

	/*
	 * 获取全部回答
	 */
	public List<Answer> getAnswers(int sid);
		


}
