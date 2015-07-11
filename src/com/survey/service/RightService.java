package com.survey.service;

import java.util.List;

import com.survey.model.security.Rights;

public interface RightService extends BaseService<Rights>{

	/*
	 * 保存或更新权限
	 */
	public void saveOrUpdateRight(Rights model);

	/*
	 * 增加权限
	 */
	public void addRight(String url);

	/*
	 * 修改一组权限
	 */
	public void updateRights(List<Rights> allRights);

	/**
	 * 获取角色的权限
	 */
	public List<Rights> getRangeRights(Integer id);

	/**
	 * 获取角色外的权限
	 */
	public List<Rights> getOutEntities(List<Rights> inRangeRights);

	/**
	 * 获得最大权限位
	 */
	public int getMaxRightPos();



}
