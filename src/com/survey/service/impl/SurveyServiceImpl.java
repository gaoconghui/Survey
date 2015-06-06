package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.Page;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{

	@Resource(name="surveyDao")
	private BaseDao<Survey> surveyDao;
	
	@Resource(name="pageDao")
	private BaseDao<Page> pageDao;;
	

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
}
