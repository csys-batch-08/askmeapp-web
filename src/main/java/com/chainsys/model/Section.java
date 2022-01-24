package com.chainsys.model;

import java.util.Objects;

public class Section {
	private String sectionName;
	private int categoryId;
	private String image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Section [sectionName=" + sectionName + ", categoryId=" + categoryId + ", image=" + image + "]";
	}
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Section(String sectionName, int categoryId, String image) {
		super();
		this.sectionName = sectionName;
		this.categoryId = categoryId;
		this.image = image;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, image, sectionName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		return categoryId == other.categoryId && Objects.equals(image, other.image)
				&& Objects.equals(sectionName, other.sectionName);
	}
	
	
	

}
