package com.askme.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askme.model.Section1;



public class SectionDao {
	public void insertSection(Section1 section) {
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
			System.out.println("Value not inserted ");
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
			
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			System.out.println("Updated successfully");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Delete section details
	public void deletedetails(String delete) {
		String deleteQuery="delete from section_details where section_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1,delete);
			pstmt.executeUpdate();
			System.out.println("Deleted successfully");
			pstmt.close();
			con.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
     
	//Find section
	public static int findSectionId(String sectionName)
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
	//List of Section
	public static List<Section1> showAllSection()
	{
		List<Section1> sectionList=new ArrayList<Section1>();
		
		String selectQuery="select * from section_details ";
		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				sectionList.add(new Section1(rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return sectionList;
	}
	
	
			
			
}


