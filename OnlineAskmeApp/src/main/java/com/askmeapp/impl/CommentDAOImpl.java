package com.askmeapp.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askmeapp.dao.CommentDAOInterface;
import com.askmeapp.model.AdminCommentView;
import com.askmeapp.model.Comment;
import com.askmeapp.model.User;
import com.askmeapp.util.ConnectionUtil;



public class CommentDAOImpl implements CommentDAOInterface{
	public  void insertComment(Comment comment) {
		//Query-insert User
		String insertQuery ="insert into comment_by_user(user_id,category_id,section_id,comments) values(?,?,?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, comment.getUserId());
			pst.setInt(2, comment.getCategoryId());
			pst.setInt(3, comment.getSectionId());	
			pst.setString(4, comment.getComments());	
			pst.executeUpdate();
			System.out.println("Your comments received successfully!!\t Reply Shortly");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fill it");
		}
	}
	//List of User
		public  ResultSet showAllComment()
		{			
			String selectQuery="select * from comment_by_user";
			
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
		//Find comment Id
		public int findCommentId(int sectionId)
		{
			String findUserId="select comment_id from comment_by_user where section_id='"+sectionId+"'";
			Connection con=ConnectionUtil.getDbConnection();
			Statement stmt;
			int commentId=0;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserId);
				if(rs.next())
				{
				commentId=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commentId;
			
		}
		//Delete 
		public void deletedetails(int commentId) {
			String deleteQuery="delete from comment_by_user where comment_id=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(deleteQuery);
				pstmt.setInt(1,commentId);
				int i=pstmt.executeUpdate();
				System.out.println("Selected comment deleted");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
}
