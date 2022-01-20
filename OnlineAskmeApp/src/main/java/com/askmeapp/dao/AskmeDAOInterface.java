package com.askmeapp.dao;

import java.sql.ResultSet;
import java.util.List;


import com.askmeapp.model.AskMe;

public interface AskmeDAOInterface {
	public void askmequestions(AskMe askMe);
	public void deletedetails(int userId);	
	public List<AskMe> showAllAskme();
	public ResultSet FindUserId( int userId,int quesId);
	
	
}
