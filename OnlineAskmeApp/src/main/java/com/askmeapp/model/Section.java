package com.askmeapp.model;

public class Section {
	private String sectionName;
	private int categoryId;
	
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
	@Override
	public String toString() {
		return "Section [sectionName=" + sectionName + ", categoryId=" + categoryId + "]";
	}
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Section(String sectionName, int categoryId) {
		super();
		this.sectionName = sectionName;
		this.categoryId = categoryId;
	}
	
	
	

}
