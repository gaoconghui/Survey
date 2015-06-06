package com.survey.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.survey.util.ReflectionUtils;

/*
 * 抽象action ，专门用于继承
 */
public abstract class  BaseAction<T> extends ActionSupport implements ModelDriven<T>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063182747110182991L;
	
	public T model;
	
	public BaseAction() {
		Class clazz = ReflectionUtils.getSuperGenericType(getClass());
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void prepare() throws Exception {
		
	}

	@Override
	public  T getModel(){
		return model;
	}

}
