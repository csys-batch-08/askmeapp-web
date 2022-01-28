package com.chainsys.model;

public class SubscribeUser {
	private int userId;
	private String sectionName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	@Override
	public String toString() {
		return "SubscribeUser [userId=" + userId + ", sectionName=" + sectionName + "]";
	}
	public SubscribeUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubscribeUser(int userId, String sectionName) {
		super();
		this.userId = userId;
		this.sectionName = sectionName;
	}
	

}
