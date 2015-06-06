package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.User;
import com.survey.service.UserService;
import com.survey.util.VaildateUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userDao")
	@Override
	public void setBaseDao(BaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
	}
	public BaseDao<User> getBaseDao(){
		return baseDao;
	}
	
	/**
	 * 判断是否占用
	 */
	@Override
	public boolean isRegistered(String email) {
		
		String hql = "From User u WHERE u.email =?";
		List<User> users = findEntityByHql(hql, email);
		
		return VaildateUtil.isVaild(users);
	}
	@Override
	public User validateLogin(String email, String md5) {
		String hql = "FROM User u WHERE u.email=? AND u.password=?";
		List<User> list = this.findEntityByHql(hql, email,md5);
		return VaildateUtil.isVaild(list)?list.get(0):null;
	}
}
