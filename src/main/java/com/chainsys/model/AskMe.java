package com.chainsys.model;

import java.util.Objects;

public class AskMe {
	private int userId;
	private int categoriesId;
	private int sectionsId;
    private int  questionsId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(int categoriesId) {
		this.categoriesId = categoriesId;
	}
	public int getSectionsId() {
		return sectionsId;
	}
	public void setSectionsId(int sectionsId) {
		this.sectionsId = sectionsId;
	}
	public int getQuestionsId() {
		return questionsId;
	}
	public void setQuestionsId(int questionsId) {
		this.questionsId = questionsId;
	}
	@Override
	public String toString() {
		return "AskMe [userId=" + userId + ", categoriesId=" + categoriesId + ", sectionsId=" + sectionsId
				+ ", questionsId=" + questionsId + "]";
	}
	public AskMe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AskMe(int userId, int categoriesId, int sectionsId, int questionsId) {
		super();
		this.userId = userId;
		this.categoriesId = categoriesId;
		this.sectionsId = sectionsId;
		this.questionsId = questionsId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoriesId, questionsId, sectionsId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AskMe other = (AskMe) obj;
		return categoriesId == other.categoriesId && questionsId == other.questionsId && sectionsId == other.sectionsId
				&& userId == other.userId;
	}
    
	
    
}
