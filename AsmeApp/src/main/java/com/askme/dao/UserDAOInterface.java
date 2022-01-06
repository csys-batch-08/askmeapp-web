package com.askme.dao;

import java.sql.ResultSet;

import com.askme.model.User;

public interface UserDAOInterface {
	
		public void insertUser(User user) ;
		public void update(String password,String email);			
		public void deletedetails(String email);		 
	    public  User validateUser(String email,String password);				
		public  int findUserId(String email);		
		public ResultSet showAllUser();
		



}
