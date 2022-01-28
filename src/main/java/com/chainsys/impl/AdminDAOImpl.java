package com.chainsys.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chainsys.dao.AdminDAOInterface;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAOInterface {
	
	public  User validateAdmin(String email,String password) {
		String validateQuery="select email,password from user_detail where role='ADMIN'and email='"+email +"' and password='"+password+"'" ;
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			//System.out.println(validateQuery);
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			//validate user input
			if(rs.next())
			{
			user=new User(0,null,email,password,null);
			}				
		} 
		catch (SQLException e) {

			e.printStackTrace();
			//System.out.println("Statement error");
		}
		return user;
	}

	


}
