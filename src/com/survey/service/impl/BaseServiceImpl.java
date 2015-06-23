package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.survey.dao.BaseDao;
import com.survey.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	BaseDao<T> baseDao;

	@Resource
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void saveEntity(T t) {
		System.out.println("save_start");
		baseDao.saveEntity(t);
		System.out.println("save_end");
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		baseDao.saveOrUpdateEntity(t);
	}

	@Override
	public void updateEntity(T t) {
		baseDao.updateEntity(t);
	}

	@Override
	public void deleteEntity(T t) {
		baseDao.deleteEntity(t);
	}

	@Override
	public void batchEntityByHql(String hql, Object... objects) {
		baseDao.batchEntityByHql(hql, objects);
	}

	@Override
	public T loadEntity(Integer id) {
		return baseDao.loadEntity(id);
	}

	@Override
	public T getEntity(Integer id) {
		return baseDao.getEntity(id);
	}

	@Override
	public List<T> findEntityByHql(String hql, Object... objects) {
		return baseDao.findEntityByHql(hql, objects);
	}
	
	@Override
	public Object ubiqueResult(String hql, Object... objects) {
		return baseDao.ubiqueResult(hql, objects);
	}

}
