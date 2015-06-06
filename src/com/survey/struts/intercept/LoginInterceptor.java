package com.survey.struts.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.survey.model.User;
import com.survey.struts.UserAware;
import com.survey.struts.action.BaseAction;
import com.survey.struts.action.LoginAction;
import com.survey.struts.action.RegAction;

@SuppressWarnings("serial")
public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		BaseAction action = (BaseAction) arg0.getAction();
		if(action instanceof LoginAction || action instanceof RegAction){
			return arg0.invoke();
		}else{
			User user = (User) arg0.getInvocationContext().getSession().get("user");
			if(user == null){
				//去登陆
				return "login";
			}else{
				if(action instanceof UserAware){
					((UserAware) action).setUser(user);
				}
				return arg0.invoke();
			}
		}
	}

}
