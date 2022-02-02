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
	public void insertAnswer(Answer answer) throws SQLException {
		//Query-insert 
		String insertQuery ="insert into answer(answers,question_id) values(?,?)";
	   //DB connection 
		
		Connection con = null;
		PreparedStatement pst = null;
		//Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,answer.getAnswers());
			pst.setInt(2,answer.getQuestion_id());	
			int i=pst.executeUpdate();
			System.out.println("Answer inserted"+i);
		}
		catch (SQLException e) {

			e.getMessage();
			System.out.println("Value not inserted ");
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
		public void update(Answer answer) throws SQLException{
			String updateQuery="update answer set answers=? where question_id=?";
			//get connection
			Connection con=null;	
			PreparedStatement pstmt=null;
			try {
				con=ConnectionUtil.getDbConnection();
				pstmt = con.prepareStatement(updateQuery);
				pstmt.setString(1,answer.getAnswers());
				pstmt.setInt(2,answer.getQuestion_id());		
				pstmt.executeUpdate();
				System.out.println("Updated sucessfully");
				
			} catch (SQLException e) {

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
		
	
	//Show All
			public List<Answer> showAllAnswer() throws SQLException
			{
				
	            List<Answer> answerList=new ArrayList<Answer>();
				
				String selectQuery="select answers,status from answer";
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = null;	
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				try {
					con = ConnectionUtil.getDbConnection();	
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
				finally {
					if(pstmt!=null) {
						pstmt.close();
					}
					if(con!=null) {
						con.close();
					}
				}
				
				return answerList;
			}
			
	//Show Answer by quesId
	public List<Answer> showAnswer(Question question) throws SQLException
	{
		
        List<Answer> answerList=new ArrayList<Answer>();
		
        String query = "select answers from answer where question_id=? and status='active'";
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			 con = ConnectionUtil.getDbConnection();	
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
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return answerList;
	}
	//Find 
		public int findQuestionId(String answers) throws SQLException
		{
			String findUserId="select question_id from answer where answers='"+answers+"'";
			Connection con=null;
			Statement stmt=null;
			int questionId=0;
			try {
				con = ConnectionUtil.getDbConnection();
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserId);
				if(rs.next())
				{
				questionId=rs.getInt(1);
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			finally {
				if(stmt!=null) {
					stmt.close();
				}
				if(con!=null) {
					con.close();
				}
			}
			return questionId;
			
		}

	
		
	}



