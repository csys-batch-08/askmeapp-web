package com.askme.dao;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.askme.model.User;
import com.askme.util.ConnectionUtil;

public class AdminDAOImpl  {
	public static User validateAdmin(String email,String password) {
		// TODO Auto-generated method stub'
		String validateQuery="select * from user_detail where role='ADMIN'and email='"+email +"' and password='"+password+"'" ;
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
	

}
