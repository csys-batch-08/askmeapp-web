package com.askmeapp.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.askmeapp.util.ConnectionUtil;

public class AdminCommentViewDAOImpl {
	//view by admin
	public ResultSet selectEmail() throws SQLException
	{
		
		
		String selectQuery="select distinct user_detail.email,comment_by_user.comments from ( user_detail  inner join comment_by_user using(user_id))";		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			 rs=stmt.executeQuery(selectQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return rs;
	}

}
