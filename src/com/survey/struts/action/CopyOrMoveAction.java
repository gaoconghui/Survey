package com.survey.struts.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.Page;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;
import com.survey.struts.UserAware;

@Controller
@Scope("prototype")
public class CopyOrMoveAction extends BaseAction<Page> implements UserAware {

	private static final long serialVersionUID = 1342859230170459157L;

	private Integer srcpid;
	private Integer tagpid;
	private Integer sid ;
	private Integer pos ;
	
	
	
	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public Integer getTagpid() {
		return tagpid;
	}

	public void setTagpid(Integer tagpid) {
		this.tagpid = tagpid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Resource
	private SurveyService surveyService;

	List<Survey> mySurveys;

	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	/*
	 * 用于接收user
	 */
	private User user;

	public void setSrcpid(Integer srcpid) {
		this.srcpid = srcpid;
	}

	public Integer getSrcpid() {
		return srcpid;
	}

	/*
	 * 去选择移动的页面
	 */
	public String toSelectMovePage() {
		mySurveys = surveyService.getSurveyWithPage(user);
		return "toSelectMovePage";
	}
	
	public String doMove(){
		
		surveyService.domove(srcpid,tagpid,pos);
		
		return "designSurveyAction";
	}
	
	

	/*
	 * 给user 赋值
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
