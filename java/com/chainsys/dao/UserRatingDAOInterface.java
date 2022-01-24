package com.chainsys.dao;

import java.sql.ResultSet;

public interface UserRatingDAOInterface{
	public  ResultSet findRating(String sectionName);
	public ResultSet showRating();
	public  void updateRating(int rating,int count,int sectionId);

}
