package com.survey.util;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import com.survey.model.User;
import com.survey.model.security.Rights;
import com.survey.struts.UserAware;
import com.survey.struts.action.BaseAction;

/**
 * 校验工具类
 * 
 * @author apple
 *
 */
public class VaildateUtil {

	/**
	 * 检验是否有效
	 * 
	 * @param src
	 */
	public static boolean isVaild(String src) {
		return !(src == null || src.trim().equals(""));
	}

	public static boolean isVaild(Collection collection) {
		return !(collection == null || collection.isEmpty());
	}

	public static boolean isVaild(Integer id) {
		return !(id == null || id == 0);
	}

	public static boolean isVaild(Object[] objs) {
		return !(objs == null || objs.length == 0);
	}

	public static boolean hasRight(String nameSpace, String actionName,
			HttpServletRequest request, BaseAction action) {

		if (!VaildateUtil.isVaild(nameSpace) || nameSpace.equals("/")) {
			nameSpace = "";
		}
		if(!VaildateUtil.isVaild(actionName)){
			return false;
		}
		if(actionName.contains(".")){
			actionName = actionName.substring(0, actionName.indexOf("."));
		}
		if (actionName.contains("?")) {
			actionName = actionName.substring(0, actionName.indexOf("?"));
		}
		String url = nameSpace + "/" + actionName;
		Map<String, Rights> map = (Map<String, Rights>) request.getSession().getServletContext().getAttribute("all rights map");
		Rights right = map.get(url);
		
		if(right == null){
			return false;
		}
		
		if (right.isCommon()) {
			return true;
		} else {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				// 去登陆
				return false;
			} else {
				if (action instanceof UserAware) {
					((UserAware) action).setUser(user);
				}
				if (user.isSuperAdmin()) {
					return true;
				} else {
					if (user.hasRight(right)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
	}

}
