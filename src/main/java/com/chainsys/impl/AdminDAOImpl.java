package com.chainsys.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.dao.AdminDAOInterface;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAOInterface {
	
	@Override
	public  User validateAdmin(String email,String password) throws SQLException {
		String validateQuery="select email,password from user_detail where role='ADMIN'and email='"+email +"' and password='"+password+"'" ;
		Connection con=null;
		PreparedStatement stmt=null;
		User user=null;
		try {
			con=ConnectionUtil.getDbConnection();
			 stmt= con.prepareStatement(validateQuery);
			ResultSet rs=stmt.executeQuery();
			//validate user input
			if(rs.next())
			{
			user=new User(0,null,email,password,null);
			}				
		} 
		catch (SQLException e) {

			e.getMessage();
			
		}
		finally {
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return user;
	}

	


}
