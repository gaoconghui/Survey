package com.survey.service;

import com.survey.model.User;

public interface UserService extends BaseService<User>{

	public boolean isRegistered(String email);

	public User validateLogin(String email, String md5);

	/**
	 * 更新用户授权
	 */
	public void updateAuthorize(User model, Integer[] userRole);

	/**
	 * 清除用户所有的权限
	 */
	public void clearAuthorize(User model);

	/**
	 * 获取user
	 */
	public User getUserWithRoles(User model);

}
