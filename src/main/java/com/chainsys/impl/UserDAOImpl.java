package com.chainsys.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.UserDAOInterface;
import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class UserDAOImpl implements UserDAOInterface {
	
	//insert user
		public void insertUser(User user) {
			//Query-insert User
			String insertQuery ="insert into user_detail(user_name,email,password) values(?,?,?)";
		   //DB connection 
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pst = null;
			//Get all values
			try {
				pst = con.prepareStatement(insertQuery);
				pst.setString(1, user.getName());
				pst.setString(2, user.getEmailId());
				pst.setString(3, user.getPassword());		
				pst.executeUpdate();
				System.out.println("Registered successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
				System.out.println("Value not inserted ");
			}
			
		}
		//Update user-password
		public void update(String password,String email){
			String updateQuery="update user_detail set password=? where email=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");		
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(updateQuery);
				pstmt.setString(1, password);
				pstmt.setString(2,email);		
				pstmt.executeUpdate();
				//System.out.println("Your Password updated successfully ");
				pstmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
	      //Login-Validate User
		 
			public  User validateUser1(String email,String password) {

				String validateQuery="select * from user_detail where role='USER' and email='"+email +"' and password='"+password+"'" ;
				Connection con=ConnectionUtil.getDbConnection();
				User user=null;
				try {
					//System.out.println(validateQuery);
					Statement stmt= con.createStatement();
					ResultSet rs=stmt.executeQuery(validateQuery);
					//validate user input
					if(rs.next())
					{
					user=new User(rs.getInt(1),rs.getString(2),email,password,rs.getString(5));
					}						
				} 
				catch (SQLException e) {

					e.printStackTrace();
					
				}
				
				return user;
			}
		//Find User
		public int findUserId(String email)
		{
			String findUserId="select user_id from user_detail where email='"+email+"'";
			Connection con=ConnectionUtil.getDbConnection();
			Statement stmt;
			int userId=0;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserId);
				if(rs.next())
				{
				userId=rs.getInt(1);
				System.out.println(userId);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userId;
			
		}
		//List of User
		public List<User> showAllUser()
		{
			
            List<User> userList=new ArrayList<User>();
			
			String selectQuery="select user_id,user_name,email,subscriber from user_detail where role='USER'";
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();	
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				pstmt = con.prepareStatement(selectQuery);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					User user=new User();
					user.setUserId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setEmailId(rs.getString(3));
					user.setSubscriber(rs.getString(4));
					userList.add(user);}
				
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}		
			
			return userList;
		}
		
		
		
		public  void updateSubscribe(User user){
			String updateQuery="update user_detail set subscriber='yes' where role='USER' and email=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");		
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(updateQuery);
				pstmt.setString(1,user.getEmailId());			
				pstmt.executeUpdate();
				System.out.println("subscribe Updated successfully");
				pstmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
			
			
		//List of Subscriber
			public  List<User> subscribeUser()
			{
				List<User> userList=new ArrayList<User>();
				
				String selectQuery="select user_name,email from user_detail where role='USER' and subscriber='yes'";
				
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();
				PreparedStatement stmt;
				try {
					stmt = con.prepareStatement(selectQuery);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{						
						User user=new User();						
						user.setName(rs.getString(1));
						user.setEmailId(rs.getString(2));						
						userList.add(user);
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}		
				
				return userList;
			}
			
			public boolean insertSection(SubscribeUser user) {
				//Query-insert User
				String insertQuery ="insert into subscribe_user(user_id,section_name) values(?,?)";
			   //DB connection 
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = ConnectionUtil.getDbConnection();
				PreparedStatement pst = null;
				//Get all values
				try {
					pst = con.prepareStatement(insertQuery);
					pst.setInt(1, user.getUserId());
					pst.setString(2, user.getSectionName());						
					pst.executeUpdate();
					System.out.println("section insert successfully");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
					System.out.println("Value not inserted ");
				}
				return true;
				
			}
			//Find User Subscriber
			public String findSubscriber(int id)
			{
				String findSubscriber="select subscriber from user_detail where user_id='"+id+"'";
				Connection con=ConnectionUtil.getDbConnection();
				Statement stmt;
				String subscriber=null;
				try {
					stmt = con.createStatement();
					ResultSet rs=stmt.executeQuery(findSubscriber);
					if(rs.next())
					{
					subscriber=rs.getString(1);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return subscriber;
				
			}
			
			
			public ResultSet emailExists(User user) throws SQLException
			{
				
				
				String selectQuery="select * from user_detail where email=?";
				
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();
				ResultSet rs=null;
				PreparedStatement pstmt=null;		
					pstmt = con.prepareStatement(selectQuery);
					pstmt.setString(1,user.getEmailId());
				   rs= pstmt.executeQuery();		
				return rs;
			}
		
			
			}
		
	
	

