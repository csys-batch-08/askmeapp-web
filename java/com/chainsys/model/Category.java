package com.chainsys.model;


public class Category {
	  
	private String CategoryName;

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [CategoryName=" + CategoryName + "]";
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName) {
		super();
		CategoryName = categoryName;
	}
   
	
    
	
	
	

}
