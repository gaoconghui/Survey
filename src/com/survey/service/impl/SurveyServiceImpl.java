package com.survey.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.Answer;
import com.survey.model.Page;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;
import com.survey.util.App;

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
		
		
		surveyDao.saveEntity(survey);
		pageDao.saveEntity(page);
		
		System.out.println(survey.getUser());
		
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

	@Override
	public void clearSurvey(Integer sid) {
		String hql  = "delete from Answer a where a.surveyId = ?";
		answerDao.batchEntityByHql(hql, sid);
	}

	@Override
	public void switchClose(Integer sid) {
		Survey survey = this.getServeyById(sid);
		String hql = "update Survey s set s.closed = ? where s.id = ?";
		surveyDao.batchEntityByHql(hql, !survey.isClosed(),sid);
	}

	@Override
	public void updatePhotoPath(Integer sid, String path) {
		String hql = "update Survey s set s.logopath = ? where s.id = ?";
		surveyDao.batchEntityByHql(hql, path,sid);
	}

	@Override
	public List<Survey> getSurveyWithPage(User user) {
		String hql = "from Survey s where s.user.id = ?";
		List<Survey> surveys = surveyDao.findEntityByHql(hql, user.getId());
		for(Survey s :surveys){
			s.getPages().size();
		}
		return surveys;
	}

	@Override
	public void domove(Integer srcpid, Integer tagpid, Integer pos) {
		Page srcPage = pageDao.getEntity(srcpid);
		Page tagPage = pageDao.getEntity(tagpid);
		Survey srcSurvey = srcPage.getSurvey();
		Survey tagSurvey = tagPage.getSurvey();
		//判断目标survey是否和原先的一致，以确定是移动还是复制
		//移动
		if(srcSurvey.getId() == tagSurvey.getId()){
			setOrderno(srcPage,tagPage,pos);
		//复制
		}else{
			srcPage.getQuestions().size();
			Page copyPage = (Page) App.deeplyCopy(srcPage);
			copyPage.setSurvey(tagSurvey);
			pageDao.saveEntity(copyPage);
			for(Question q : copyPage.getQuestions()){
				questionDao.saveEntity(q);
			}
			setOrderno(copyPage,tagPage,pos);
		}
		
	}

	private void setOrderno(Page srcPage, Page tagPage, Integer pos) {
		//向前
		if(pos == 0){
			//判断目标页是否是首页
			if(isFirstPage(tagPage)){
				srcPage.setOrderno(tagPage.getOrderno()-0.1f);
			}else{
				Page prePage = getPrePage(tagPage);
				srcPage.setOrderno((tagPage.getOrderno()+prePage.getOrderno())/2);
			}
		}else{
			//向后
			//判断目标页是否是尾页
			if(isLastPage(tagPage)){
				srcPage.setOrderno(tagPage.getOrderno()+0.1f);
			}else{
				Page nextPage = getNextPage(tagPage);
				srcPage.setOrderno((tagPage.getOrderno()+nextPage.getOrderno())/2);
			}
			
		}
	}

	private Page getNextPage(Page tagPage) {
		String hql = "from Page p where p.orderno > ? and p.survey.id = ? order by orderno asc";
		List<Page> list = pageDao.findEntityByHql(hql, tagPage.getOrderno(),tagPage.getSurvey().getId());
		return list.get(0);
	}

	private Page getPrePage(Page tagPage) {
		String hql = "from Page p where p.orderno < ? and p.survey.id = ? order by orderno desc";
		List<Page> list = pageDao.findEntityByHql(hql, tagPage.getOrderno(),tagPage.getSurvey().getId());
		return list.get(0);		
	}

	private boolean isLastPage(Page tagPage) {
		String hql = "select count(*) from Page p where p.orderno < ? and p.survey.id = ?";
		long count = (long) pageDao.uniqueResult(hql, tagPage.getOrderno(),tagPage.getSurvey().getId());
		return count == 0;
	}

	private boolean isFirstPage(Page tagPage) {
		String hql = "select count(*) from Page p where p.orderno > ? and p.survey.id = ?";
		long count = (long) pageDao.uniqueResult(hql, tagPage.getOrderno(),tagPage.getSurvey().getId());
		return count == 0;
	}

	@Override
	public List<Survey> getAllOpenSurveys() {
		String hql = "from Survey s where s.closed = ?";
		return surveyDao.findEntityByHql(hql, false);
	}

	@Override
	public Page getFirstPage(int sid) {
		String hql = "from Page p where p.survey.id = ? order by orderno asc";
		Page page = pageDao.findEntityByHql(hql, sid).get(0);
		page.getQuestions().size();
		page.getSurvey().getTitle();
		return page;
	}

	@Override
	public Page getPrePage(int currPid) {
		Page p = pageDao.getEntity(currPid);
		p = this.getPrePage(p);
		p.getQuestions().size();
		return p;
	}

	@Override
	public Page getNextPage(int currPid) {
		Page p = pageDao.getEntity(currPid);
		p = this.getNextPage(p);
		p.getQuestions().size();
		return p;
	}

	@Override
	public void saveAnswers(ArrayList<Answer> answers) {
		String uuid = UUID.randomUUID().toString();
		Date date = new Date();
		for(Answer answer : answers){
			answer.setUuid(uuid);
			answer.setAnswerTime(date);
			answerDao.saveEntity(answer);
		}
	}

	@Override
	public List<Question> getQuestions(int sid) {
		String hql = "from Question q where q.page.survey.id = ? order by id";
		return questionDao.findEntityByHql(hql, sid);
	}

	@Override
	public List<Answer> getAnswers(int sid) {
		String hql = "from Answer a where a.surveyId = ? order by uuid,questionId";
		return answerDao.findEntityByHql(hql, sid);
	}

}
