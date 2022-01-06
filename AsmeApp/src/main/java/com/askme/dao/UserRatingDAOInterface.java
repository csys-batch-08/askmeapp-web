package com.askme.dao;

import java.sql.ResultSet;

public interface UserRatingDAOInterface{
	public  int findRating(String sectionName);
	public ResultSet showRating();
	

}
