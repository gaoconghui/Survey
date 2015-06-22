package com.survey.struts.action;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.SurveyService;
import com.survey.struts.UserAware;
import com.survey.util.VaildateUtil;

@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware,ServletContextAware {

	private static final long serialVersionUID = -5486473866918566562L;
	
	private List<Survey> mySurveys;
	
	private Integer sid;
	
	private File logoPhoto;
	private String logoPhotoFileName;
	
	private String inputPage;
	
	public String getInputPage() {
		return inputPage;
	}
	
	public String getLogoPhotoFileName() {
		return logoPhotoFileName;
	}
	public void setLogoPhotoFileName(String logoPhotoFileName) {
		this.logoPhotoFileName = logoPhotoFileName;
	}
	public File getLogoPhoto() {
		return logoPhoto;
	}


	public void setLogoPhoto(File logoPhoto) {
		this.logoPhoto = logoPhoto;
	}


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
	/*
	 * 清除调查回答
	 */
	public String clearSurvey(){
		surveyService.clearSurvey(sid);
		return "toSurveyAction";
	}
	/*
	 * 转换开关
	 */
	public String switchClose(){
		surveyService.switchClose(sid);
		return "toSurveyAction";
	}
	/*
	 * 到添加logo 页面
	 */
	public String toAddLogo(){
		return "toAddLogoPage";
	}
	/*
	 * 添加logo
	 */
	public String addLogo(){
		String dir = sc.getRealPath("/upload");
		long l = System.nanoTime();
		String ext = logoPhotoFileName.substring(logoPhotoFileName.lastIndexOf("."));
		File newFile = new File(dir,l+ext);
		logoPhoto.renameTo(newFile);
		
		surveyService.updatePhotoPath(sid,"/upload/"+l+ext);
		return "designSurveyAction";
	}
	
	public void prepareAddLogo(){
		inputPage = "addLogo.jsp";
	}
	
	/*
	 * 判断照片是否存在
	 */
	public boolean photoExists(){
		String path = model.getLogopath();
		if(VaildateUtil.isVaild(path)){
			String absPath = sc.getRealPath(path);
			File file = new File(absPath);
			return file.exists();
		}
		return false;
	}


	@Override
	public void setUser(User user) {
		this.user = user;
	}

	private ServletContext sc;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}

}
