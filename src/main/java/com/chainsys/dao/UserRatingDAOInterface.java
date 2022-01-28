package com.chainsys.dao;

import java.sql.ResultSet;
import java.util.List;

import com.chainsys.model.UserRating;

public interface UserRatingDAOInterface{
	public  ResultSet findRating(String sectionName);
	public List<UserRating> showRating();
	public  void updateRating(int rating,int count,int sectionId);

}
