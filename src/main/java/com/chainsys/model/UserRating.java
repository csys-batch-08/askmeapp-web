package com.chainsys.model;

import java.util.Objects;

public class UserRating {
	private String sectionName;
	private int categoryId;
	private int rating;
	private int rateCount;
	
	public int getRateCount() {
		return rateCount;
	}
	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "UserRating [sectionName=" + sectionName + ", categoryId=" + categoryId + ", rating=" + rating
				+ ", rateCount=" + rateCount + "]";
	}
	public UserRating() {
		super();

	}
	public UserRating(String sectionName, int categoryId, int rating, int rateCount) {
		super();
		this.sectionName = sectionName;
		this.categoryId = categoryId;
		this.rating = rating;
		this.rateCount = rateCount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, rateCount, rating, sectionName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRating other = (UserRating) obj;
		return categoryId == other.categoryId && rateCount == other.rateCount && rating == other.rating
				&& Objects.equals(sectionName, other.sectionName);
	}
	

}
