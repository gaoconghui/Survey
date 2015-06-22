package com.survey.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.Page;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.service.SurveyService;

@Controller
@Scope("prototype")
public class QuestionAction extends BaseAction<Question>{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4532580160540007025L;
	@Resource
	private SurveyService surveyService;
	private Integer sid;
	private Integer pid;
	private Integer qid;
	
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getPid() {
		return pid;
	}
	
	public String selectQuestionType(){
		return "toSelectQuestionTypePage";
	}
	
	public String designQuestion(){
		return model.getQuestionType();
	}
	
	public String updateQuestion(){
		Page page = new Page();
		page.setId(pid);
		model.setPage(page);
		surveyService.saveOrUpdateQuestion(model);
		return "designSurveyAction";
	}
	/*
	 * 删除问题
	 */
	public String deleteQuestion(){
		surveyService.deleteQuestion(qid);
		return "designSurveyAction"; 
	}
	/*
	 * 编辑问题
	 */
	public String editQuestion(){
		model = surveyService.getQuestion(qid);
		return model.getQuestionType();
	}
	
	
	
}
