package com.survey.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.security.Rights;
import com.survey.model.security.Role;
import com.survey.service.RightService;
import com.survey.service.RoleService;
import com.survey.util.DataUtil;
import com.survey.util.VaildateUtil;

@Service("rightService")
public class RightServiceImpl extends BaseServiceImpl<Rights> implements
		RightService {

	@Resource(name="rightDao")
	@Override
	public void setBaseDao(BaseDao<Rights> baseDao) {
		super.setBaseDao(baseDao);
	}
	
	@Resource
	BaseDao<Role> roleDao;
	@Resource
	RoleService roleService;

	@Override
	public void saveOrUpdateRight(Rights model) {
		
//		String hql = "from Rights order by rightPos desc,rightCode desc";
//		List<Rights> rights =  this.findEntityByHql(hql);
		if(model.getId() == null){
			int rightPos = 0;
			long rightCode = 1L;
			
			String hql = "select max(r.rightPos),max(r.rightCode) from Rights r where r.rightPos = "
					+ "(select max(rr.rightPos) from Rights rr))";
			
			Object[] arr = (Object[]) this.uniqueResult(hql);
			
			
			if(arr[0] != null && arr[1] != null){
				rightCode = (long) arr[1];
				rightPos = (int) arr[0];
				if(rightCode<<1 <= (1L << 60)){
					rightCode = rightCode << 1 ;
				}else{
					rightCode = 1 ;
					rightPos ++ ; 
				}
			}
			
			model.setRightCode(rightCode);
			model.setRightPos(rightPos);
		}
		
		this.saveOrUpdateEntity(model);
		
	}

	@Override
	public void addRight(String url) {
		String hql = "select count(*) from Rights r where r.rightUrl = ? ";
		Long length = (Long) this.uniqueResult(hql, url);
		
		Rights right ;
		
		if(length == 0){
			right = new Rights();
			right.setRightUrl(url);
			this.saveOrUpdateRight(right);
		}
	}

	@Override
	public void updateRights(List<Rights> allRights) {
		for(Rights right : allRights){
			this.updateEntity(right);
		}
	}

	@Override
	public List<Rights> getRangeRights(Integer id) {
		return new ArrayList<Rights>(roleDao.getEntity(id).getRights());
	}

	@Override
	public List<Rights> getOutEntities(List<Rights> inRangeRights) {
		if(!VaildateUtil.isVaild(inRangeRights)){
			return this.getAllEntities();
		}else{
			String hql = "from Rights r where r.id not in (" + DataUtil.extractIds(inRangeRights) + ")";
			return this.findEntityByHql(hql);
		}
	}

	@Override
	public int getMaxRightPos() {
		String hql = "select max(r.rightPos) from Rights r";
		Integer pos = (Integer) this.uniqueResult(hql);
		return pos == null? 0 : pos;
	}

}
