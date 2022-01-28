package com.chainsys.model;

import java.util.Objects;

public class Section {
	private int sectionId;
	private String sectionName;
	private int categoryId;
	private String status;
	private String image;
	
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", sectionName=" + sectionName + ", categoryId=" + categoryId
				+ ", status=" + status + ", image=" + image + "]";
	}
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Section(int sectionId, String sectionName, int categoryId, String status, String image) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.categoryId = categoryId;
		this.status = status;
		this.image = image;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, image, sectionId, sectionName, status);
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
		return categoryId == other.categoryId && Objects.equals(image, other.image) && sectionId == other.sectionId
				&& Objects.equals(sectionName, other.sectionName) && Objects.equals(status, other.status);
	}
	
	
	
	

}
