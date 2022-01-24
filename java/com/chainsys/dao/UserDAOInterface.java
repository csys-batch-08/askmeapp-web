package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public interface UserDAOInterface {
	
		public void insertUser(User user) ;
		public void update(String password,String email);			
		public  User validateUser1(String email,String password);
		public int findUserId(String email);
		public ResultSet showAllUser(); 
		public void updateSubscribe(User user);
		public  List<User> subscribeUser();
		public boolean insertSection(SubscribeUser user);
		public String findSubscriber(int id);
		public ResultSet showAllSection(int id);	
			
}	



