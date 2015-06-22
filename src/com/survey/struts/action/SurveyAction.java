package com.survey.struts.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;
import com.survey.struts.UserAware;

@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware {

	private static final long serialVersionUID = -5486473866918566562L;
	
	private List<Survey> mySurveys;
	
	private Integer sid;
	
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public List<Survey> getMySurveys() {
		return mySurveys;
	}


	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}


	@Resource
	private SurveyService surveyService;
	private User user;
	
	
	/**
	 * 显示所有的调查信息
	 */
	public String toMySurvey(){
		this.mySurveys = surveyService.getAllSurvey(user);
		return "toSurveyPage";
	}
	
	/**
	 * 新建调查
	 */
	public String newSurvey(){
		this.model = surveyService.newSurvey(user);
		return "designSurvey";
	}
	
	/**
	 * 设计调查
	 */
	public String designSurvey(){
		this.model=surveyService.getServeyByIdWithChild(sid);
		return "designSurvey";
	}
	/**
	 *编辑 
	 */
	public String editServey(){
		this.model = surveyService.getServeyById(sid);
		return "editServey";
	}
	/**
	 *更新 
	 */
	public String updateServey(){
		this.sid = model.getId();
		model.setUser(user);
		surveyService.updateSurvey(model);
		return "designSurveyAction";
	}

	/*
	 * 删除页面调查
	 */
	public String deleteSurvey(){
		surveyService.deleteSurvey(sid);
		return "toSurveyAction";
	}


	@Override
	public void setUser(User user) {
		this.user = user;
	}

}
