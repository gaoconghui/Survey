package com.survey.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.security.Rights;
import com.survey.model.security.Role;
import com.survey.service.RightService;
import com.survey.service.RoleService;

/**
 * 角色管理Action
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	private List<Role> allRoles = new ArrayList<Role>();
	private List<Rights> outRangeRights = new ArrayList<Rights>();
	private List<Rights> inRangeRights = new ArrayList<Rights>();
	private Integer[] roleRight;

	public void setRoleRight(Integer[] roleRight) {
		this.roleRight = roleRight;
	}

	public List<Rights> getOutRangeRights() {
		return outRangeRights;
	}

	public List<Rights> getInRangeRights() {
		return inRangeRights;
	}

	public List<Role> getAllRoles() {
		return allRoles;
	}

	@Resource
	private RoleService roleService;
	@Resource
	private RightService rightService;

	private static final long serialVersionUID = -8377197419908948181L;

	/**
	 * 获得全部权限，跳转到权限管理页面
	 */
	public String findAllRoles() {
		this.allRoles = roleService.getAllEntities();
		return "roleListPage";
	}

	/**
	 * 增加角色
	 */
	public String addRole() {
		this.outRangeRights = rightService.getAllEntities();
		return "editRole";
	}

	/**
	 * 保存或更新role
	 */
	public String saveOrUpdateRole() {

		roleService.saveOrUpdateRole(model, roleRight);

		return "toRoleListPage";
	}
	
	/**
	 * 更新角色
	 */
	public String editRole(){
		this.inRangeRights = rightService.getRangeRights(model.getId());
		this.outRangeRights = rightService.getOutEntities(inRangeRights);
		this.model = roleService.getEntity(model.getId());
		return "editRole";
	}
	
	public String deleteRole(){
		roleService.deleteEntity(model);
		return "toRoleListPage";
	}

}
