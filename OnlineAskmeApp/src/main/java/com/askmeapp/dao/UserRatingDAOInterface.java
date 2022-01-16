package com.askmeapp.dao;

import java.sql.ResultSet;

public interface UserRatingDAOInterface{
	public  int findRating(String sectionName);
	public ResultSet showRating();
	

}
