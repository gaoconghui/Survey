package com.survey.struts.intercept;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.survey.service.RightService;
import com.survey.util.VaildateUtil;

public class CatchRightInterceptor implements Interceptor {

	private static final long serialVersionUID = -2035976620716973063L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionProxy actionProxy = invocation.getProxy();
		String nameSpace = actionProxy.getNamespace();
		String actionName = actionProxy.getActionName();

		if (!VaildateUtil.isVaild(nameSpace) || nameSpace.equals("/")) {
			nameSpace = "";
		}

		String url = nameSpace + "/" + actionName;

		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(ServletActionContext
						.getServletContext());
		RightService rightService = (RightService) ac.getBean("rightService");
		rightService.addRight(url);

		return invocation.invoke();
	}

}
