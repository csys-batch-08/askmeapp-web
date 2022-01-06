package com.askme.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askme.dao.QuestionDAOInterface;
import com.askme.model.Question;
import com.askme.model.Section;
import com.askme.util.ConnectionUtil;


public class QuestionDAOImpl implements QuestionDAOInterface {
	
	
	public void insertQuestion(Question question) {
		//Query-insert 
		String insertQuery ="insert into question_details(question_description,section_id) values(?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,question.getQuestion());
			pst.setInt(2,question.getSectionId());	
			pst.executeUpdate();
			System.out.println("Question inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	//Update 
	public void update(String update,int id){
		String updateQuery="update question_details set question_description=? where question_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, update);
			pstmt.setInt(2, id);		
			int i=pstmt.executeUpdate();
			System.out.println(i+"row updated");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Delete 
	public void deletedetails(String delete) {
		String deleteQuery="delete from question_details where question_description=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1,delete);
			int i=pstmt.executeUpdate();
			System.out.println("Your question deleted");
			pstmt.close();
			con.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
     
	//Find 
	public  int findQuestionId(String quesdes)
	{
		String findUserId="select question_id from question_details where question_description='"+quesdes+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int questionId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUserId);
			if(rs.next())
			{
			questionId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionId;
		
	}
	//List 
	public  ResultSet showAllQuestion()
	{
		
		String selectQuery="select * from question_details";
		
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
	//Search by Question
		public ResultSet showQuestion(int id)
		{
			
			String query = "select * from question_details where section_id=?";
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
	
	

}
