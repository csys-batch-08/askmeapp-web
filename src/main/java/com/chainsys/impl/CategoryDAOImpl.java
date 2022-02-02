package com.chainsys.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.CategoryDAOInterface;
import com.chainsys.model.Category;
import com.chainsys.util.ConnectionUtil;



public class CategoryDAOImpl implements CategoryDAOInterface{
	@Override
	public void insertCategory(Category category) throws SQLException {
		//insert 
		final String insertQuery ="insert into category_detail(category_name) values(?)";
	   //DB connection 
		
		Connection con = null;
		PreparedStatement pst = null;
		//Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,category.getCategoryName());
			pst.executeUpdate();
			
		}
		catch (final SQLException e) {

			e.printStackTrace();			
		}
		finally {
			if(pst!=null) {
				pst.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
	}
	//Update 
	@Override
	public void update(Category category) throws SQLException{
		final String updateQuery="update category_detail set category_name=?  where category_id=?";
		//get connection
		Connection con=null;			
		PreparedStatement pstmt=null;
		try {
			con=ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, category.getCategoryName());
			pstmt.setInt(2, category.getCategoryId());
			pstmt.executeUpdate();
			
			
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
	}
	
     
	//Find 
	@Override
	public int findCategoryId(String categoryName) throws SQLException
	{
		final String findUserId="select category_id from category_detail where category_name='"+categoryName+"'";
		Connection con=null;
		Statement stmt=null;
		int categoryId=0;
		try {
			 con=ConnectionUtil.getDbConnection();
			stmt = con.createStatement();
			final ResultSet rs=stmt.executeQuery(findUserId);
			if(rs.next())
			{
			categoryId=rs.getInt(1);
			}
			
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				stmt.close();
			}
			
		}
		return categoryId;
		
	}
	//Update Inactive
		@Override
		public void updateInactive(int id) throws SQLException{
			
			final String updateQuery="update category_detail set status='Inactive' where category_id=?";
			Connection con =null;	
			PreparedStatement pstmt=null;
			try {
				con = ConnectionUtil.getDbConnection();
				pstmt = con.prepareStatement(updateQuery);	
				System.out.println(id);
				pstmt.setInt(1,id);	
				pstmt.executeUpdate();
							
			} catch (final SQLException e) {

				e.printStackTrace();
			}
			finally {
				if(pstmt!=null) {
					pstmt.close();
				}
				
			}
			
			final String updateQuery1="update section_details set status='Inactive' where category_id=?";		
			PreparedStatement pstmt1=null;
			
			try {
				pstmt1 = con.prepareStatement(updateQuery1);					
				pstmt1.setInt(1,id);	
				final int i=pstmt1.executeUpdate();
				System.out.println("section update successfully "+i);
			} catch (final SQLException e) {

				e.printStackTrace();
			}
			finally {
				if(pstmt1!=null) {
					pstmt1.close();
				}
				
			}
			final String updateQuery2="update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";		
			PreparedStatement pstmt2=null;
			try {
				pstmt2 = con.prepareStatement(updateQuery2);					
				final int i=pstmt2.executeUpdate();
				System.out.println("question update successfully "+i);
			} catch (final SQLException e) {

				e.printStackTrace();
			}
			finally {
				if(pstmt2!=null) {
					pstmt2.close();
				}
				
			}
			final String updateQuery3="update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";		
			PreparedStatement pstmt3=null;
			try {
				pstmt3 = con.prepareStatement(updateQuery3);					
				final int i=pstmt3.executeUpdate();
				System.out.println("answer update successfully "+i);
				
			} catch (final SQLException e) {

				e.printStackTrace();
			}
			finally {
				if(pstmt3!=null) {
					pstmt3.close();
				}
				
			}
			
			
		}
		
		//Update Active
	@Override
	public void updateActive(int id){					
					//get connection
					final Connection con=ConnectionUtil.getDbConnection();
					final String updateQuery="update category_detail set status='active' where category_id=?";	
					PreparedStatement pstmt=null;
					try {
						pstmt = con.prepareStatement(updateQuery);	
						System.out.println(id);
						pstmt.setInt(1,id);	
						final int i=pstmt.executeUpdate();
						System.out.println("update  active successfully "+i);
					} catch (final SQLException e) {

						e.printStackTrace();
					}
					final String updateQuery1="update section_details set status='active' where category_id=?";		
					PreparedStatement pstmt1=null;
					try {
						pstmt1 = con.prepareStatement(updateQuery1);					
						pstmt1.setInt(1,id);	
						final int i=pstmt1.executeUpdate();
						System.out.println("section update successfully "+i);
					} catch (final SQLException e) {

						e.printStackTrace();
					}
					final String updateQuery2="update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";		
					PreparedStatement pstmt2=null;
					try {
						pstmt2 = con.prepareStatement(updateQuery2);					
						final int i=pstmt2.executeUpdate();
						pstmt2.executeUpdate("commit");
						System.out.println("question update successfully "+i);
					} catch (final SQLException e) {

						e.printStackTrace();
					}
					final String updateQuery3="update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";		
					
					try {
						final PreparedStatement pstmt3 = con.prepareStatement(updateQuery3);					
						final int i=pstmt3.executeUpdate();
						System.out.println("answer update successfully "+i);
						
					} catch (final SQLException e) {

						e.printStackTrace();
					}
					
					
				}
	//List of category for admin
			@Override
			public List<Category> showAllCategory()
			{
				final List<Category> categoryList=new ArrayList<Category>();
				
				final String selectQuery="select category_id,category_name from category_detail where status='active'";
				
				final ConnectionUtil conUtil = new ConnectionUtil();
				final Connection con = conUtil.getDbConnection();
				PreparedStatement stmt=null;
				ResultSet rs=null;
				
				try {
					stmt = con.prepareStatement(selectQuery);
					rs=stmt.executeQuery();
					while(rs.next()) {
						final Category category=new Category();	
						category.setCategoryId(rs.getInt(1));
						category.setCategoryName(rs.getString(2));						
						categoryList.add(category);}
						
					}
					
				 catch (final SQLException e) {

					e.printStackTrace();
				}		
				
				return categoryList;
			}
		
	//List of category for admin
			@Override
			public List<Category> AllCategory()
			{
				final List<Category> categoryList=new ArrayList<Category>();
				
				final String selectQuery="select category_id,category_name,status from category_detail";
				
				final ConnectionUtil conUtil = new ConnectionUtil();
				final Connection con = conUtil.getDbConnection();
				PreparedStatement stmt=null;
				ResultSet rs=null;
				
				try {
					stmt = con.prepareStatement(selectQuery);
					rs=stmt.executeQuery();
					while(rs.next()) {
						final Category category=new Category();
						category.setCategoryId(rs.getInt(1));
						category.setCategoryName(rs.getString(2));
						category.setStatus(rs.getString(3));
						categoryList.add(category);}
						
					}
					
				 catch (final SQLException e) {

					e.printStackTrace();
				}		
				
				return categoryList;
			}
		
	
	
		
	//Find Status
				@Override
				public String findStatus(int id)
				{
					final String findUserId="select status from category_detail where category_id='"+id+"'";
					final Connection con=ConnectionUtil.getDbConnection();
					Statement stmt;
					String status=null;
					try {
						stmt = con.createStatement();
						final ResultSet rs=stmt.executeQuery(findUserId);
						if(rs.next())
						{
						status=rs.getString(1);
						}
						
					} catch (final SQLException e) {

						e.printStackTrace();
					}
					return status;
					
				}
	
		 

}
