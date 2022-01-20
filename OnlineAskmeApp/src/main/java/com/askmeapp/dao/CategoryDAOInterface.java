package com.askmeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.askmeapp.model.Category;
import com.askmeapp.util.ConnectionUtil;

public interface CategoryDAOInterface {
	public void insertCategory(Category category);	
	public void update(String categoryName,int id);	 
	public  int findCategoryId(String categoryName);	
	public ResultSet showAllCategory();
	public void updateInactive(int id);	
	public ResultSet AllCategory();
	public String findStatus(int id);
	public void updateActive(int id);		
}
