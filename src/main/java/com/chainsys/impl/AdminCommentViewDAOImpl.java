package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.AdminCommentView;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class AdminCommentViewDAOImpl {
	//view by admin
			public List<AdminCommentView> commentView()
			{
				
	            List<AdminCommentView> commentList=new ArrayList<AdminCommentView>();
				
				String selectQuery="select distinct user_detail.email,comment_by_user.comments from ( user_detail  inner join comment_by_user using(user_id))";
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();	
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					pstmt = con.prepareStatement(selectQuery);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						AdminCommentView comment=new AdminCommentView();
						comment.setEmail(rs.getString(1));
						comment.setComment(rs.getString(2));
						commentList.add(comment);}
					
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}		
				
				return commentList;
			}
			

}
