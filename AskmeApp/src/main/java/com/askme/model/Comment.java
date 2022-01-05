package com.askme.model;

import java.util.Objects;

public class Comment {
	private int userId;	
	private int categoryId;
	private int sectionId;
	private String comments;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int userId, int categoryId, int sectionId, String comments) {
		super();
		this.userId = userId;
		this.categoryId = categoryId;
		this.sectionId = sectionId;
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", categoryId=" + categoryId + ", sectionId=" + sectionId + ", comments="
				+ comments + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, comments, sectionId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return categoryId == other.categoryId && Objects.equals(comments, other.comments)
				&& sectionId == other.sectionId && userId == other.userId;
	}
	
	

}
