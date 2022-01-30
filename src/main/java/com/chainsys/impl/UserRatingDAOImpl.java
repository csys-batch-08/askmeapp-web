package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.UserRatingDAOInterface;
import com.chainsys.model.Section;
import com.chainsys.model.User;
import com.chainsys.model.UserRating;
import com.chainsys.util.ConnectionUtil;



public class UserRatingDAOImpl implements UserRatingDAOInterface {
	//rating update
	public  void updateRating(UserRating userRating){
		String updateQuery="update section_details set rating=?,rating_count=? where section_name=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);			
			pstmt.setInt(1,userRating.getRating());
			pstmt.setInt(2, userRating.getRateCount());
			pstmt.setString(3,userRating.getSectionName());
			pstmt.executeUpdate();
			System.out.println("helo");
			System.out.println("Rating Updated successfully");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
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
			
			//User Place Rating
			public  List<UserRating> findRating(Section section)
			{
				
				List<UserRating> rateList=new ArrayList<UserRating>();
				String findRating="select rating,rating_count from section_details where section_name=?";
				Connection con=ConnectionUtil.getDbConnection();
				PreparedStatement pst=null;
					
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					
					pstmt = con.prepareStatement(findRating);
					pstmt.setString(1, section.getSectionName());
					rs=pstmt.executeQuery();
					while(rs.next()) {
						UserRating rate=new UserRating();
						rate.setRating(rs.getInt(1));
						rate.setRateCount(rs.getInt(2));						
						rateList.add(rate);
						}			
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}		
				
				return rateList;
			}



			
	
}
