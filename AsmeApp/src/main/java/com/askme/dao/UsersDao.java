package com.askme.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askme.model.User;



public class UsersDao {
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
			int i=pstmt.executeUpdate();
			System.out.println("Your Password updated successfully ");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Delete user details
	public void deletedetails(String email) {
		String deleteQuery="delete from user_detail where email=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1,email);
			int i=pstmt.executeUpdate();
			System.out.println("Selected user deleted");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
      //Login-Validate User
	public static User validateUser(String email,String password) {
		// TODO Auto-generated method stub'
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
			user=new User(rs.getString(2),email,password );
			}						
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}
		
		return user;
	}
	//Find User
	public static int findUserId(String email)
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
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
		
	}
	//List of User
	public static List<User> showAllUser()
	{
		List<User> userList=new ArrayList<User>();
		
		String selectQuery="select * from user_detail where role='USER'";
		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				userList.add(new User(rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return userList;
	}

		
	}
	

