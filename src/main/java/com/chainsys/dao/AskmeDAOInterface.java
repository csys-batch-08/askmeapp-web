package com.chainsys.dao;


import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.AskMe;

public interface AskmeDAOInterface {
	public void askmequestions(AskMe askMe) throws SQLException;	
	public List<AskMe> FindUserId( AskMe askMe) throws SQLException;		
	
	
}
