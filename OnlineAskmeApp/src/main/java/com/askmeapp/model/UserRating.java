package com.askmeapp.model;

public class UserRating {
	private String sectionName;
	private int categoryId;
	private int rating;
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "UserRating [sectionName=" + sectionName + ", categoryId=" + categoryId + ", rating=" + rating + "]";
	}
	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRating(String sectionName, int categoryId, int rating) {
		super();
		this.sectionName = sectionName;
		this.categoryId = categoryId;
		this.rating = rating;
	}
	
	

}
