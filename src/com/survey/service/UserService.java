package com.survey.service;

import com.survey.model.User;

public interface UserService extends BaseService<User>{

	public boolean isRegistered(String email);

	public User validateLogin(String email, String md5);

}
