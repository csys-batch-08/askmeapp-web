package com.chainsys.dao;

import java.sql.ResultSet;
import java.util.List;

import com.chainsys.model.AskMe;

public interface AskmeDAOInterface {
	public void askmequestions(AskMe askMe);	
	public List<AskMe> showAllAskme();
	public ResultSet FindUserId( int userId,int quesId);
	
	
}
