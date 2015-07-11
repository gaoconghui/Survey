package com.survey.model.security;

import com.survey.model.BaseEntity;

/*
 * 权限
 */
public class Rights extends BaseEntity {

	private static final long serialVersionUID = 3063912301954365900L;
	private Integer id;
	private String rightName = "未命名";
	private String rightUrl;
	private String rightDesc = "";
	private long rightCode; // 权限码 1<<n
	private Integer rightPos; // 权限位，相当于权限分组，从0开始
	private boolean common; // 是否为公共资源

	public boolean isCommon() {
		return common;
	}

	public void setCommon(boolean common) {
		this.common = common;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getRightUrl() {
		return rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightDesc() {
		return rightDesc;
	}

	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
	}

	public long getRightCode() {
		return rightCode;
	}

	public void setRightCode(long rightCode) {
		this.rightCode = rightCode;
	}

	public Integer getRightPos() {
		return rightPos;
	}

	public void setRightPos(Integer rightPos) {
		this.rightPos = rightPos;
	}

}
