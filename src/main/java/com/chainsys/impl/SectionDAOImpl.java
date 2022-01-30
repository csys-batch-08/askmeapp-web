package com.chainsys.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.SectionDAOInterface;
import com.chainsys.model.Category;
import com.chainsys.model.Section;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;



public class SectionDAOImpl implements SectionDAOInterface{
	public void insertSection(Section section) {
		//Query-insert User
		String insertQuery ="insert into section_details(section_name,category_id,image) values(?,?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			System.out.println(section.getSectionName());
			pst.setString(1,section.getSectionName());
			System.out.println(section.getCategoryId());
			pst.setInt(2,section.getCategoryId());
			System.out.println(section.getImage());
			pst.setString(3, section.getImage());
			int i=pst.executeUpdate();
			System.out.println("Section inserted"+i);
		}
		catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Values not inserted ");
		}
		
	}
	//Update 
	public void update(Section section){
		String updateQuery="update section_details set section_name=?  where section_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, section.getSectionName());			
			pstmt.setInt(2, section.getSectionId());
			int i=pstmt.executeUpdate();
			System.out.println("Updated successfully"+i);
			
		} catch (SQLException e) {

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

			e.printStackTrace();
		}
		return sectionId;
		
	}
	//Search by category name
	public List<Section> showSectionName(Category category)
	{
		
        List<Section> sectionList=new ArrayList<Section>();
		
		String selectQuery="select section_id,section_name from section_details where category_id=? and status='active'";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();	
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = con.prepareStatement(selectQuery);			
			pstmt.setInt(1,category.getCategoryId());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Section section=new Section();	
				section.setSectionId(rs.getInt(1));
				section.setSectionName(rs.getString(2));				
				sectionList.add(section);
				}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}		
		
		return sectionList;
	}


	
	
	//show all
				public List<Section> showAllSection()
				{
					
		            List<Section> sectionList=new ArrayList<Section>();
					
					String selectQuery="select section_id,section_name,status from section_details";
					ConnectionUtil conUtil = new ConnectionUtil();
					Connection con = conUtil.getDbConnection();	
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						pstmt = con.prepareStatement(selectQuery);
						rs=pstmt.executeQuery();
						while(rs.next()) {
							Section section=new Section();
							section.setSectionId(rs.getInt(1));
							section.setSectionName(rs.getString(2));
							section.setStatus(rs.getString(3));
							sectionList.add(section);
							}
						
						
					} catch (SQLException e) {
					
						e.printStackTrace();
					}		
					
					return sectionList;
				}
				
				
		
}


