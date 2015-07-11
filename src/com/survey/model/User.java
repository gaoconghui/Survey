package com.survey.model;

import java.util.HashSet;
import java.util.Set;

import com.survey.model.security.Rights;
import com.survey.model.security.Role;

public class User extends BaseEntity {

	private static final long serialVersionUID = -6705953371666223690L;
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String nickName;

	private boolean superAdmin;
	// 权限综合
	private long[] rightSum;

	private Set<Role> roles = new HashSet<Role>();

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	public long[] getRightSum() {
		return rightSum;
	}

	public void setRightSum(long[] rightSum) {
		this.rightSum = rightSum;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 计算权限
	 */
	public void calculateRights() {
		int pos = 0;
		long code = 0;

		for (Role role : roles) {
			if(role.getRoleValue().equals("-1")){
				this.superAdmin = true;
				roles = null;
				return;
			}
			for (Rights right : role.getRights()) {
				pos = right.getRightPos();
				code = right.getRightCode();
				rightSum[pos] = rightSum[pos] | code;
			}
		}

		roles = null;
	}

	public boolean hasRight(Rights right) {
		int pos = right.getRightPos();
		long code = right.getRightCode();
		return !((rightSum[pos] & code) == 0);
	}

}
