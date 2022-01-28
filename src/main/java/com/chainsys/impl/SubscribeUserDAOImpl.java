package com.chainsys.impl;

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

public class SubscribeUserDAOImpl {
	
	//List of User
			public List<SubscribeUser> showAllSection(User user)
			{
				
	            List<SubscribeUser> subscribeUserList=new ArrayList<SubscribeUser>();
				
				String selectQuery="select section_name from (subscribe_user inner join user_detail  using(user_id)) where user_id=?";
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();	
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					pstmt = con.prepareStatement(selectQuery);					
					pstmt.setInt(1,user.getUserId());
					System.out.println(user.getUserId());
					rs=pstmt.executeQuery();				
					while(rs.next()) {	
						SubscribeUser subscribeUser=new SubscribeUser();
						subscribeUser.setSectionName(rs.getString(1));	
						
						subscribeUserList.add(subscribeUser);}
					
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}		
				
				return subscribeUserList;
			}
			

}
