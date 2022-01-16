package com.askmeapp.dao;

import java.sql.ResultSet;


import com.askmeapp.model.Category;

public interface CategoryDAOInterface {
	public void insertCategory(Category category);	
	public void update(String categoryName,int id);	
	public void deletedetails(String delete);  
	public  int findCategoryId(String categoryName);	
	public ResultSet showAllCategory();


}
