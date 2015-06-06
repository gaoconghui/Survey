package com.survey.struts.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.User;
import com.survey.service.UserService;
import com.survey.util.DataUtil;

/**
 * 登陆Action
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware{

	private static final long serialVersionUID = -5089037854135312994L;

	@Resource
	private UserService userService;
	
	public String toLogin(){
		return "toLoginPage";
	}
	
	public String doLogin(){
		return SUCCESS;
	}
	
	//vaildate 后棉加方法名，为该方法的验证
	public void validateDoLogin() {
		User user = userService.validateLogin(model.getEmail(),DataUtil.md5(model.getPassword()));
		if(user == null){
			addActionError("email/密码错误无法登陆");
			return ;
		}else{
			session.put("user", user);
		}
	}

	private Map<String,Object> session ;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
