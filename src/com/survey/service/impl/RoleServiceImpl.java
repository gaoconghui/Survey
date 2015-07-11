package com.survey.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.User;
import com.survey.model.security.Rights;
import com.survey.model.security.Role;
import com.survey.service.RoleService;
import com.survey.util.DataUtil;
import com.survey.util.StringUtil;
import com.survey.util.VaildateUtil;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	@Resource(name = "roleDao")
	@Override
	public void setBaseDao(BaseDao<Role> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Resource
	BaseDao<Rights> rightDao;
	@Resource
	BaseDao<User> userDao;

	@Override
	public void saveOrUpdateRole(Role role, Integer[] roleRight) {
		if (!VaildateUtil.isVaild(roleRight)) {
			role.getRights().clear();
		} else {
			List<Rights> rights = findRightInRange(roleRight);
			role.setRights(new HashSet<Rights>(rights));
		}
		
		this.saveOrUpdateEntity(role);
	}

	/**
	 * 查询在范围内的权限
	 */
	public List<Rights> findRightInRange(Integer[] roleRight) {

		String hql = "from Rights r where r.id in ("
				+ StringUtil.arr2Str(roleRight) + ")";

		return rightDao.findEntityByHql(hql);
	}

	@Override
	public List<Role> getRangeRole(Integer id) {
		return new ArrayList<Role>(userDao.getEntity(id).getRoles());
	}

	@Override
	public List<Role> getOutRangeRole(List<Role> inRangeRoles) {
		if(!VaildateUtil.isVaild(inRangeRoles)){
			return this.getAllEntities();
		}else{
			String hql = "from Role r where r.id not in (" + DataUtil.extractIds(inRangeRoles) + ")";
			return this.findEntityByHql(hql);
		}
	}

}
