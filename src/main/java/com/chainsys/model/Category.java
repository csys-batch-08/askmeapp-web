package com.chainsys.model;

import java.util.Objects;

public class Category {
	private int categoryId;  
	private String categoryName;
    private String status;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Category() {
		super();

	}
	public Category(int categoryId, String categoryName, String status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, categoryName, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return categoryId == other.categoryId && Objects.equals(categoryName, other.categoryName)
				&& Objects.equals(status, other.status);
	}
	
	
	

}
