package com.askmeapp.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askmeapp.dao.SectionDAOInterface;
import com.askmeapp.model.Section;
import com.askmeapp.util.ConnectionUtil;



public class SectionDAOImpl implements SectionDAOInterface{
	public void insertSection(Section section) {
		//Query-insert User
		String insertQuery ="insert into section_details(section_name,category_id) values(?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,section.getSectionName());
			pst.setInt(2,section.getCategoryId());	
			pst.executeUpdate();
			System.out.println("Section inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Values not inserted ");
		}
		
	}
	//Update 
	public void update(String update,int id){
		String updateQuery="update section_details set section_name=?  where section_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, update);			
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Updated successfully");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
     
	//Find section
	public  int findSectionId(String sectionName)
	{
		String findUserId="select section_id from section_details where section_name='"+sectionName+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int sectionId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUserId);
			if(rs.next())
			{
			sectionId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sectionId;
		
	}
	
	
	//Search by category name
	public  ResultSet showSectionName(int id)
	{
		String query = "select * from section_details where category_id=? and status='active'";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		ResultSet rs=null;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			 rs=stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return rs;
	}
	//show all
		public  ResultSet showAllSection()
		{
			String query = "select * from section_details";
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();
			ResultSet rs=null;
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(query);
				 rs=stmt.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return rs;
		}
	
		
}


