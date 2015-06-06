package com.survey.struts.action;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.User;
import com.survey.service.UserService;
import com.survey.util.DataUtil;
import com.survey.util.VaildateUtil;

/**
 * 注册action
 * @author apple
 *
 */
@Controller
@Scope("prototype")
public class RegAction extends BaseAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6420809407434688316L;


	private String confirmPassword;
	
	@Resource
	UserService userService ;

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@SkipValidation
	public String toReg() {
		return "regPage";
	}

	public String doReg() {
		model.setPassword(DataUtil.md5(model.getPassword()));
		userService.saveEntity(model);
		return "doRegister";
	}

	@Override
	public void validate() {
		clearErrors();
		if (!VaildateUtil.isVaild(model.getEmail())) {
			addFieldError("email", "email是必填项");
		}
		if (!VaildateUtil.isVaild(model.getPassword())) {
			addFieldError("password", "密码是必填项");
		}
		if (!VaildateUtil.isVaild(model.getNickName())) {
			addFieldError("nickName", "名称是必填项");
		}
		if(hasErrors()) return;
		
		if(!model.getPassword().equals(confirmPassword)){
			addFieldError("password", "两次输入密码不通");
			return;
		}
		
		if(userService.isRegistered(model.getEmail())){
			addFieldError("email", "email已经注册");
			return;
		}
		
	}


}
