package com.chainsys.dao;


import java.sql.SQLException;

import java.util.List;

import com.chainsys.model.Category;


public interface CategoryDAOInterface {
	public void insertCategory(Category category) throws SQLException;	
	public void update(Category category) throws SQLException;	 
	public  int findCategoryId(String categoryName) throws SQLException;	
	public List<Category> showAllCategory();
	public void updateInactive(int id) throws SQLException;	
	public List<Category> AllCategory();
	public String findStatus(int id);
	public void updateActive(int id);		
}
