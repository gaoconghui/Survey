package com.survey.struts.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.security.Rights;
import com.survey.service.RightService;
import com.survey.util.VaildateUtil;

/**
 * 登陆Action
 */
@Controller
@Scope("prototype")
public class RightAction extends BaseAction<Rights> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627822262624746160L;
	@Resource
	private RightService rightService;
	private List<Rights> allRights;

	public List<Rights> getAllRights() {
		return allRights;
	}

	public void setAllRights(List<Rights> allRights) {
		this.allRights = allRights;
	}

	/*
	 * 获得全部权限，跳转到权限管理页面
	 */
	public String findAllRights() {

		this.allRights = rightService.getAllEntities();
		return "toRightManagerPage";
	}

	/*
	 * 增加权限
	 */
	public String addRight() {
		return "toEditRightPage";
	}

	/*
	 * 保存/更新权限
	 */
	public String saveOrUpdateRight() {

		rightService.saveOrUpdateRight(model);
		return "findAllRightsAction";
	}

	/*
	 * 单击修改，到修改权限页面
	 */
	public String editRight() {
		this.model = rightService.getEntity(model.getId());
		return "toEditRightPage";
	}

	/*
	 * 删除权限
	 */
	public String deleteRight() {
		rightService.deleteEntity(model);
		return "findAllRightsAction";
	}
	
	/*
	 * 修改一组权限
	 */
	public String UpdateRights(){
		if(VaildateUtil.isVaild(allRights)){
			rightService.updateRights(allRights);
		}
		return "findAllRightsAction";
	}

}
