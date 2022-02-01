package com.chainsys.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.AnswerDAOInterface;
import com.chainsys.model.Answer;
import com.chainsys.model.Question;
import com.chainsys.util.ConnectionUtil;

public class AnswerDAOImpl implements AnswerDAOInterface{
	//insert
	public void insertAnswer(Answer answer) {
		//Query-insert 
		String insertQuery ="insert into answer(answers,question_id) values(?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,answer.getAnswers());
			pst.setInt(2,answer.getQuestion_id());	
			int i=pst.executeUpdate();
			System.out.println("Answer inserted"+i);
		}
		catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	
	//Update 
		public void update(Answer answer){
			String updateQuery="update answer set answers=? where question_id=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");		
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(updateQuery);
				pstmt.setString(1,answer.getAnswers());
				pstmt.setInt(2,answer.getQuestion_id());		
				int i=pstmt.executeUpdate();
				System.out.println("Updated sucessfully");
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
	
	//Show All
			public List<Answer> showAllAnswer()
			{
				
	            List<Answer> answerList=new ArrayList<Answer>();
				
				String selectQuery="select answers,status from answer";
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();	
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					pstmt = con.prepareStatement(selectQuery);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						Answer answer=new Answer();
						answer.setAnswers(rs.getString(1));
						answer.setStatus(rs.getString(2));
						answerList.add(answer);}				
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}		
				
				return answerList;
			}
			
	//Show Answer by quesId
	public List<Answer> showAnswer(Question question)
	{
		
        List<Answer> answerList=new ArrayList<Answer>();
		
        String query = "select answers from answer where question_id=? and status='active'";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();	
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,question.getQuestionId());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Answer answer=new Answer();
				answer.setAnswers(rs.getString(1));				
				answerList.add(answer);}				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}		
		
		return answerList;
	}
	//Find 
		public int findQuestionId(String answers)
		{
			String findUserId="select question_id from answer where answers='"+answers+"'";
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

				e.printStackTrace();
			}
			return questionId;
			
		}

	
		
	}



