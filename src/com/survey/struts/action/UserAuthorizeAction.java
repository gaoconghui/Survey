package com.survey.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.survey.model.User;
import com.survey.model.security.Role;
import com.survey.service.RoleService;
import com.survey.service.UserService;

/**
 * 角色管理Action
 */
@Controller
@Scope("prototype")
public class UserAuthorizeAction extends BaseAction<User> {

	private List<User> allUsers = new ArrayList<User>();
	private List<Role> outRangeRoles = new ArrayList<Role>();
	private List<Role> inRangeRoles = new ArrayList<Role>();
	private Integer[] userRole;
	
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;

	public List<User> getAllUsers() {
		return allUsers;
	}

	public List<Role> getOutRangeRoles() {
		return outRangeRoles;
	}

	public List<Role> getInRangeRoles() {
		return inRangeRoles;
	}

	public void setUserRole(Integer[] userRole) {
		this.userRole = userRole;
	}

	/**
	 * 获得全部用户，跳转到用户授权页面
	 */
	public String findAllUsers() {
		this.allUsers = userService.getAllEntities();
		return "userListPage";
	}

	/**
	 * 更新用户
	 */
	public String editUser() {
		this.model = userService.getEntity(model.getId());
		this.inRangeRoles = roleService.getRangeRole(model.getId());
		this.outRangeRoles = roleService.getOutRangeRole(inRangeRoles);
		return "editRole";
	}

	/**
	 * 用户授权
	 */
	public String updateUserRole() {
		userService.updateAuthorize(model,userRole);
		return "toUserListPage";
	}
	
	/**
	 * 用户授权
	 */
	public String clearAuthorize() {
		userService.clearAuthorize(model);
		return "toUserListPage";
	}



}
