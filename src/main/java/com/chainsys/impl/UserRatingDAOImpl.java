package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.UserRatingDAOInterface;
import com.chainsys.model.User;
import com.chainsys.model.UserRating;
import com.chainsys.util.ConnectionUtil;



public class UserRatingDAOImpl implements UserRatingDAOInterface {
	public  void updateRating(int rating,int count,int sectionId){
		String updateQuery="update section_details set rating=?,rating_count=? where section_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1,rating);
			pstmt.setInt(2, count);
			pstmt.setInt(3,sectionId);
			pstmt.executeUpdate("commit");
			//System.out.println("Rating Updated successfully");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
		
	public  ResultSet findRating(String sectionName)
	{
		String findRating="select rating,rating_count from section_details where section_name='"+sectionName+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int rating=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findRating);
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//priority by rating
	
			public List<UserRating> showRating()
			{
				
	            List<UserRating> userRatingList=new ArrayList<UserRating>();
				
				String selectQuery="select section_name,rating,rating_count from section_details  where status='active'";
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();	
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					pstmt = con.prepareStatement(selectQuery);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						UserRating ratingList=new UserRating();
						ratingList.setSectionName(rs.getString(1));
						ratingList.setRating(rs.getInt(2));
						ratingList.setRateCount(rs.getInt(3));
						userRatingList.add(ratingList);
						}					
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}		
				
				return userRatingList;
			}
			
	
}
