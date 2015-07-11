package com.survey.service;

import java.util.List;
import java.util.Set;

import com.survey.model.security.Role;

public interface RoleService extends BaseService<Role>{

	/**
	 * 保存或更新角色
	 */
	public void saveOrUpdateRole(Role model, Integer[] roleRight);

	/**
	 * 根据id 获得其所有角色
	 */
	public List<Role> getRangeRole(Integer id);

	/**
	 * 获得范围外的全部的role
	 */
	public List<Role> getOutRangeRole(List<Role> inRangeRoles);



}
