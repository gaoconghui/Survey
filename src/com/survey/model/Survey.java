package com.survey.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Survey extends BaseEntity{

	private static final long serialVersionUID = 2688845107412703125L;
	private User user;
	private Set<Page> pages = new HashSet<Page>();

	private Integer id;
	private String title = "新问卷";
	private String preText = "上一步";
	private String nextText = "下一步";
	private String editTest = "退出";
	private String doneText = "完成";
	private Date createTime = new Date();

	private boolean closed;
	private String logopath;
	private float minOrderno;
	private float maxOrderno;

	public float getMinOrderno() {
		return minOrderno;
	}

	public void setMinOrderno(float minOrderno) {
		this.minOrderno = minOrderno;
	}

	public float getMaxOrderno() {
		return maxOrderno;
	}

	public void setMaxOrderno(float maxOrderno) {
		this.maxOrderno = maxOrderno;
	}

	public String getLogopath() {
		return logopath;
	}

	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getTitle() {
		return title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreText() {
		return preText;
	}

	public void setPreText(String preText) {
		this.preText = preText;
	}

	public String getNextText() {
		return nextText;
	}

	public void setNextText(String nextText) {
		this.nextText = nextText;
	}

	public String getEditTest() {
		return editTest;
	}

	public void setEditTest(String editTest) {
		this.editTest = editTest;
	}

	public String getDoneText() {
		return doneText;
	}

	public void setDoneText(String doneText) {
		this.doneText = doneText;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	// @Override
	// public String toString() {
	// return "Survey [user=" + user.getId() + ", pages=" + pages + ", id=" + id
	// + ", title=" + title + ", preText=" + preText + ", nextText="
	// + nextText + ", editTest=" + editTest + ", doneText="
	// + doneText + ", createTime=" + createTime + "]";
	// }

}
