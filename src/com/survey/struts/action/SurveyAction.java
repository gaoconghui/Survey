package com.survey.struts.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
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
		System.out.println(mySurveys);
		return "toSurveyPage";
	}
	
	/**
	 * 新建调查
	 */
	public String newSurvey(){
		this.model = surveyService.newSurvey(user);
		ActionContext.getContext().getValueStack().push(model);
		return "designSurvey";
	}
	
	/**
	 * 设计调查
	 */
	public String designServey(){
		this.model=surveyService.getServeyById(sid);
		return "designSurvey";
	}



	@Override
	public void setUser(User user) {
		this.user = user;
	}

}
