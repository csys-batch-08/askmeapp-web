package com.askme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.askme.model.Answer;
import com.askme.model.Question;
import com.askme.util.ConnectionUtil;

public class AnswerDAOImpl {
	public void insertAnswer(Answer answer) {
		//Query-insert User
		String insertQuery ="insert into answer(answers,question_id) values(?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,answer.getAnswer());
			pst.setInt(2,answer.getQuestion_id());	
			pst.executeUpdate();
			System.out.println("Answer inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	public static ResultSet showAllAnswer()
	{
		
		String query = "select * from answer";
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
