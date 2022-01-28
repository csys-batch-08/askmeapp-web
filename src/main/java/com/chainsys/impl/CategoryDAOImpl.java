package com.chainsys.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.controller.AddCategoryServlet;
import com.chainsys.dao.CategoryDAOInterface;
import com.chainsys.model.Category;
import com.chainsys.util.ConnectionUtil;



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

			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	//Update 
	public void update(Category category){
		String updateQuery="update category_detail set category_name=?  where category_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			//System.out.println(category.getCategoryName());
			//System.out.println(category.getCategoryId());
			pstmt.setString(1, category.getCategoryName());
			pstmt.setInt(2, category.getCategoryId());
			int i=pstmt.executeUpdate();
			//System.out.println("updated successfully"+i);
			
		} catch (SQLException e) {

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

				e.printStackTrace();
			}
			String updateQuery3="update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";		
			
			try {
				PreparedStatement pstmt3 = con.prepareStatement(updateQuery3);					
				int i=pstmt3.executeUpdate();
				System.out.println("answer update successfully "+i);
				
			} catch (SQLException e) {

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

						e.printStackTrace();
					}
					String updateQuery2="update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";		
					PreparedStatement pstmt2=null;
					try {
						pstmt2 = con.prepareStatement(updateQuery2);					
						int i=pstmt2.executeUpdate();
						pstmt2.executeUpdate("commit");
						System.out.println("question update successfully "+i);
					} catch (SQLException e) {

						e.printStackTrace();
					}
					String updateQuery3="update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";		
					
					try {
						PreparedStatement pstmt3 = con.prepareStatement(updateQuery3);					
						int i=pstmt3.executeUpdate();
						System.out.println("answer update successfully "+i);
						
					} catch (SQLException e) {

						e.printStackTrace();
					}
					
					
				}
	//List of category for admin
			public List<Category> showAllCategory()
			{
				List<Category> categoryList=new ArrayList<Category>();
				
				String selectQuery="select category_id,category_name from category_detail where status='active'";
				
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();
				PreparedStatement stmt=null;
				ResultSet rs=null;
				
				try {
					stmt = con.prepareStatement(selectQuery);
					rs=stmt.executeQuery();
					while(rs.next()) {
						Category category=new Category();	
						category.setCategoryId(rs.getInt(1));
						category.setCategoryName(rs.getString(2));						
						categoryList.add(category);}
						
					}
					
				 catch (SQLException e) {

					e.printStackTrace();
				}		
				
				return categoryList;
			}
		
	//List of category for admin
			public List<Category> AllCategory()
			{
				List<Category> categoryList=new ArrayList<Category>();
				
				String selectQuery="select category_id,category_name,status from category_detail";
				
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();
				PreparedStatement stmt=null;
				ResultSet rs=null;
				
				try {
					stmt = con.prepareStatement(selectQuery);
					rs=stmt.executeQuery();
					while(rs.next()) {
						Category category=new Category();
						category.setCategoryId(rs.getInt(1));
						category.setCategoryName(rs.getString(2));
						category.setStatus(rs.getString(3));
						categoryList.add(category);}
						
					}
					
				 catch (SQLException e) {

					e.printStackTrace();
				}		
				
				return categoryList;
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
