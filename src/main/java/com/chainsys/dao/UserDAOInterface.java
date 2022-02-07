package com.chainsys.dao;


import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;


public interface UserDAOInterface {
	
	
		public void insertUser(User user) throws SQLException;		
		public void update(String password, String email) throws SQLException;
		public User validateUser1(String email, String password) throws SQLException;
		public List<User> showAllUser() throws SQLException;
		public void updateSubscribe(User user) throws SQLException;		
		public List<User> subscribeUser() throws SQLException;
		public boolean insertSection(SubscribeUser user) throws SQLException;		
		public String findSubscriber(int id) throws SQLException;
		public List<User> emailExists(User user) throws SQLException;
		public int findUserId(String email) throws SQLException;

		
			
}	



