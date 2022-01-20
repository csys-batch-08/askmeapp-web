package com.askmeapp.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askmeapp.controller.AddCategoryServlet;
import com.askmeapp.dao.CategoryDAOInterface;
import com.askmeapp.model.Category;
import com.askmeapp.util.ConnectionUtil;



public class CategoryDAOImpl implements CategoryDAOInterface{
	public void insertCategory(Category category) {
		//insert 
		String insertQuery ="insert into category_detail(category_name) values(?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,category.getCategoryName());
			pst.executeUpdate();
			System.out.println("Category inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	//Update 
	public void update(String categoryName,int id){
		String updateQuery="update category_detail set category_name=?  where category_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, categoryName);
			pstmt.setInt(2, id);		
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
     
	//Find 
	public int findCategoryId(String categoryName)
	{
		String findUserId="select category_id from category_detail where category_name='"+categoryName+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int categoryId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUserId);
			if(rs.next())
			{
			categoryId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryId;
		
	}
	//Update Inactive
		public void updateInactive(int id){
			Connection con = ConnectionUtil.getDbConnection();
			String updateQuery="update category_detail set status='Inactive' where category_id=?";
			System.out.println("Connection successfully established");		
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(updateQuery);	
				System.out.println(id);
				pstmt.setInt(1,id);	
				int i=pstmt.executeUpdate();
				System.out.println("category inactive update successfully "+i);				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			String updateQuery1="update section_details set status='Inactive' where category_id=?";		
			PreparedStatement pstmt1=null;
			try {
				pstmt1 = con.prepareStatement(updateQuery1);					
				pstmt1.setInt(1,id);	
				int i=pstmt1.executeUpdate();
				System.out.println("section update successfully "+i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String updateQuery2="update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";		
			PreparedStatement pstmt2=null;
			try {
				pstmt2 = con.prepareStatement(updateQuery2);					
				int i=pstmt2.executeUpdate();
				System.out.println("question update successfully "+i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String updateQuery3="update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";		
			PreparedStatement pstmt3=null;
			try {
				pstmt2 = con.prepareStatement(updateQuery3);					
				int i=pstmt3.executeUpdate();
				System.out.println("answer update successfully "+i);
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//Update Active
	public void updateActive(int id){					
					//get connection
					Connection con=ConnectionUtil.getDbConnection();
					String updateQuery="update category_detail set status='active' where category_id=?";	
					PreparedStatement pstmt=null;
					try {
						pstmt = con.prepareStatement(updateQuery);	
						System.out.println(id);
						pstmt.setInt(1,id);	
						int i=pstmt.executeUpdate();
						System.out.println("update  active successfully "+i);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String updateQuery1="update section_details set status='active' where category_id=?";		
					PreparedStatement pstmt1=null;
					try {
						pstmt1 = con.prepareStatement(updateQuery1);					
						pstmt1.setInt(1,id);	
						int i=pstmt1.executeUpdate();
						System.out.println("section update successfully "+i);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String updateQuery2="update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";		
					PreparedStatement pstmt2=null;
					try {
						pstmt2 = con.prepareStatement(updateQuery2);					
						int i=pstmt2.executeUpdate();
						System.out.println("question update successfully "+i);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String updateQuery3="update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";		
					PreparedStatement pstmt3=null;
					try {
						pstmt3 = con.prepareStatement(updateQuery3);					
						int i=pstmt3.executeUpdate();
						System.out.println("answer update successfully "+i);
						pstmt.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
	//List of category for user
	public ResultSet showAllCategory()
	{
		
		
		String selectQuery="select * from category_detail where status='active'";
		
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
	
	//List of category for admin
		public ResultSet AllCategory()
		{
			
			
			String selectQuery="select * from category_detail";
			
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
	
		
	//Find Status
				public String findStatus(int id)
				{
					String findUserId="select status from category_detail where category_id='"+id+"'";
					Connection con=ConnectionUtil.getDbConnection();
					Statement stmt;
					String status=null;
					try {
						stmt = con.createStatement();
						ResultSet rs=stmt.executeQuery(findUserId);
						if(rs.next())
						{
						status=rs.getString(1);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return status;
					
				}
	
		 

}
