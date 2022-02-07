package com.chainsys.dao;



import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.Section;
import com.chainsys.model.UserRating;

public interface UserRatingDAOInterface{
	public  List<UserRating> findRating(Section section) throws SQLException;
	public List<UserRating> showRating() throws SQLException;
	public  void updateRating(UserRating userRating) throws SQLException;

}
