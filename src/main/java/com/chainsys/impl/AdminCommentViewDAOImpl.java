package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.AdminCommentViewDAOInterface;
import com.chainsys.model.AdminCommentView;
import com.chainsys.util.ConnectionUtil;

public class AdminCommentViewDAOImpl  implements AdminCommentViewDAOInterface{
	//view by admin
			public List<AdminCommentView> commentView() throws SQLException
			{
				
	            List<AdminCommentView> commentList=new ArrayList<>();
				
				String selectQuery="select distinct user_detail.email,comment_by_user.comments from ( user_detail  inner join comment_by_user using(user_id))";
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					 con = ConnectionUtil.getDbConnection();	
					pstmt = con.prepareStatement(selectQuery);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						AdminCommentView comment=new AdminCommentView();
						comment.setEmail(rs.getString(1));
						comment.setComment(rs.getString(2));
						commentList.add(comment);}
					
					
				} catch (SQLException e) {
				
					e.getMessage();
				}
				finally
				{
					if(pstmt!=null) {
						pstmt.close();
						
					}
					if(con!=null) {
						con.close();
					}
				}
				
				return commentList;
			}
			

}
