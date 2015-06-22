package com.survey.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.Page;
import com.survey.model.Survey;
import com.survey.service.SurveyService;

@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5411626081892663894L;

	@Resource
	private SurveyService surveyService;
	private Integer sid;
	private Integer pid;
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public String addPage(){
		return "toPageDetail";
	}
	
	public String saveOrUpadatePage(){
		Survey survey = new Survey();
		survey.setId(sid);
		model.setSurvey(survey);
		surveyService.saveOrUpdatePage(model);
		return "designSurveyAction";
	}
	
	public String editPage(){
		model = surveyService.getPageById(pid);
		return "toPageDetail";
	}
	
	/**
	 * 删除页面
	 * @return
	 */
	public String deletePage(){
		surveyService.deletePage(pid);
		return "designSurveyAction";
	}
	
	
}
