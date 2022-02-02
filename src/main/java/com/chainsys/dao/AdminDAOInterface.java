package com.chainsys.dao;

import java.sql.SQLException;

import com.chainsys.model.User;

public interface AdminDAOInterface {
	public  User validateAdmin(String email,String password) throws SQLException;

}
