package com.survey.struts.intercept;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.survey.struts.action.BaseAction;
import com.survey.util.VaildateUtil;

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

		ActionProxy actionProxy = arg0.getProxy();
		String nameSpace = actionProxy.getNamespace();
		String actionName = actionProxy.getActionName();

		if (VaildateUtil.hasRight(nameSpace, actionName,
				ServletActionContext.getRequest(), action)) {
			return arg0.invoke();
		} else {
			return "login";
		}

	}

}
