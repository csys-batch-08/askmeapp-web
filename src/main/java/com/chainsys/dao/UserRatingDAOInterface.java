package com.chainsys.dao;



import java.util.List;

import com.chainsys.model.Section;
import com.chainsys.model.UserRating;

public interface UserRatingDAOInterface{
	public  List<UserRating> findRating(Section section);
	public List<UserRating> showRating();
	public  void updateRating(UserRating userRating);

}
