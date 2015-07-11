package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import com.survey.dao.BaseDao;
import com.survey.service.BaseService;
import com.survey.util.ReflectionUtils;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> baseDao;

	Class<T> clazz;

	public BaseServiceImpl() {
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	@Resource
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void saveEntity(T t) {
		baseDao.saveEntity(t);
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
	public Object uniqueResult(String hql, Object... objects) {
		return baseDao.uniqueResult(hql, objects);
	}

	@Override
	public List<T> getAllEntities() {
		String hql = "from " + clazz.getSimpleName();
		return baseDao.findEntityByHql(hql);
	}
	
	@Override
	public void executeSql(String sql, Object... objects) {
		baseDao.executeSql(sql, objects);
	}
	
	@Override
	public List executeSQLQuery(Class clazz,String sql, Object... objects) {
		return baseDao.executeSQLQuery(clazz,sql, objects);
	}

}
