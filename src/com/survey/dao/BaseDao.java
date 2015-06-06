package com.survey.dao;

import java.util.List;

/**
 * baseDao接口
 * @author apple
 *
 * @param <T>
 */
public interface BaseDao<T> {

	
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHql(String hql,Object ...objects);
	
	public T loadEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntityByHql(String hql,Object...objects);
}