package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.Answer;
import com.survey.model.Page;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{

	@Resource(name="surveyDao")
	private BaseDao<Survey> surveyDao;
	
	@Resource(name="pageDao")
	private BaseDao<Page> pageDao;;
	
	@Resource(name="questionDao")
	private BaseDao<Question> questionDao;;
	
	@Resource(name="answerDao")
	private BaseDao<Answer> answerDao;;
	

	@Override
	public List<Survey> getAllSurvey(User user) {
		String hql = "FROM Survey s WHERE s.user.id=?";
		return surveyDao.findEntityByHql(hql, user.getId());
	}

	@Override
	public Survey newSurvey(User user) {
		Survey survey = new Survey();
		Page page = new Page();
		
		survey.setUser(user);
		survey.getPages().add(page);
		page.setSurvey(survey);
		
		System.out.println(survey);
		
		surveyDao.saveEntity(survey);
		pageDao.saveEntity(page);
		
		
		return survey;
	}

	@Override
	public Survey getServeyById(Integer sid) {
		return surveyDao.getEntity(sid);
	}

	@Override
	public Survey getServeyByIdWithChild(Integer sid) {
		Survey survey = this.getServeyById(sid);
		for(Page page : survey.getPages()){
			page.getQuestions().size();
		}
		return survey;
	}

	@Override
	public void updateSurvey(Survey model) {
		surveyDao.updateEntity(model);
	}

	@Override
	public void saveOrUpdatePage(Page model) {
		pageDao.saveOrUpdateEntity(model);
	}

	@Override
	public Page getPageById(Integer pid) {
		return pageDao.getEntity(pid);
	}

	@Override
	public void saveOrUpdateQuestion(Question model) {
		questionDao.saveOrUpdateEntity(model);
	}

	@Override
	public void deleteQuestion(Integer qid) {
		String hql = "delete from Answer a where a.questionId = ?";
		answerDao.batchEntityByHql(hql, qid);
		
		hql = "delete from Question q where q.id = ?";
		questionDao.batchEntityByHql(hql, qid);
	}

	@Override
	public void deletePage(Integer pid) {
		String hql = "delete from Answer a where a.questionId  in (select q.id from Question q where q.page.id = ? )";
		answerDao.batchEntityByHql(hql, pid);
		
		hql = "delete from Question q where q.page.id = ?";
		questionDao.batchEntityByHql(hql, pid);
		
		hql = "delete from Page p where p.id = ?";
		pageDao.batchEntityByHql(hql, pid);
		
	}

	@Override
	public void deleteSurvey(Integer sid) {
		
		String hql = "delete from Answer a where a.surveyId = ?";
		answerDao.batchEntityByHql(hql, sid);
		
		hql = "delete from Question q where q.page.id in (select p.id from Page p where p.survey.id = ?)";
		questionDao.batchEntityByHql(hql, sid);
		
		hql = "delete from Page p where p.survey.id = ?";
		pageDao.batchEntityByHql(hql, sid);
		
		hql = "delete from Survey s where s.id = ?";
		surveyDao.batchEntityByHql(hql, sid);
	}

	@Override
	public Question getQuestion(Integer qid) {
		return questionDao.getEntity(qid);
	}

}
