package com.survey.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.User;
import com.survey.model.security.Role;
import com.survey.service.UserService;
import com.survey.util.DataUtil;
import com.survey.util.StringUtil;
import com.survey.util.VaildateUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Resource(name = "userDao")
	@Override
	public void setBaseDao(BaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Resource
	BaseDao<Role> roleDao ;
	
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
		List<User> list = this.findEntityByHql(hql, email, md5);
		if(VaildateUtil.isVaild(list)){
			User user = list.get(0);
			for(Role role : user.getRoles()){
				role.getRights().size();
			}
			return user ;
		}
		return null;
	}

	@Override
	public void updateAuthorize(User model, Integer[] userRole) {
		User user = this.getEntity(model.getId());
		if (!VaildateUtil.isVaild(userRole)) {
			user.getRoles().clear();
		} else {
			String hql = "from Role r where r.id in (" + StringUtil.arr2Str(userRole) + ")";
			user.setRoles(new HashSet<Role>(roleDao.findEntityByHql(hql)));
		}
	}

	@Override
	public void clearAuthorize(User model) {
		this.getEntity(model.getId()).getRoles().clear();
	}

	@Override
	public User getUserWithRoles(User model) {
		String hql = "FROM User u WHERE u.email=? AND u.password=?";
		List<User> list = this.findEntityByHql(hql, model.getEmail(), DataUtil.md5(model.getPassword()));
		return list.get(0);
	}
}
