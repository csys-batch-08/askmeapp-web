package com.chainsys.model;

public class AskMe {
	private int userId;
	private int categoryId;
	private int sectionId;
    private int  questionId;
    
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
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	@Override
	public String toString() {
		return "AskMe [userId=" + userId + ", categoryId=" + categoryId + ", sectionId=" + sectionId + ", questionId="
				+ questionId + "]";
	}
	public AskMe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AskMe(int userId, int categoryId, int sectionId, int questionId) {
		super();
		this.userId = userId;
		this.categoryId = categoryId;
		this.sectionId = sectionId;
		this.questionId = questionId;
	}
    
	
	
    
}
