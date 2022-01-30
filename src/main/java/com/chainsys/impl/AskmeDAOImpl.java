package com.chainsys.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.AskmeDAOInterface;
import com.chainsys.model.AskMe;
import com.chainsys.util.ConnectionUtil;



public class AskmeDAOImpl implements AskmeDAOInterface {
	//insert	
		public  void askmequestions(AskMe askMe) {
			String insertQuery ="insert into ask_me_questions(user_id,category_id,section_id,question_id) values(?,?,?,?)";
			   //DB connection 
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();
				PreparedStatement pst = null;
				//Get all values
				try {
					pst = con.prepareStatement(insertQuery);				
					pst.setInt(1,askMe.getUserId());	
					pst.setInt(2, askMe.getCategoryId());
					pst.setInt(3, askMe.getSectionId());
					pst.setInt(4, askMe.getQuestionId());
					pst.executeUpdate();
					//System.out.println("Thank you for your intention to ask a question. However, you have asked any question. Please ask and we will be happy to support you.");
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println("Value not inserted ");
				}
				
			}
		
		
		public  List<AskMe> showAllAskme()
		{
			List<AskMe> askMeList=new ArrayList<AskMe>();
			
			String selectQuery="select user_detail.user_name,question_details.question_description from((user_detail inner join ask_me_questions using(user_id))inner join question_details using (question_id));";
			
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(selectQuery);
				while(rs.next())
				{
					askMeList.add(new AskMe(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return askMeList;
		}
		
		public List<AskMe> FindUserId( AskMe askMe)		{
			List<AskMe> askList=new ArrayList<AskMe>();
			
			String selectQuery="select ask_me_questions.question_id from (user_detail inner join ask_me_questions using(user_id))where user_id=? and question_id=?";
			
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();
			PreparedStatement pst = null;
			ResultSet rs=null;
			try {
				pst = con.prepareStatement(selectQuery);				
				pst.setInt(1,askMe.getUserId());	
				pst.setInt(2, askMe.getQuestionId());
				rs=pst.executeQuery();
			    while(rs.next()) {
			    	AskMe ask=new AskMe();
			    	ask.setQuestionId(rs.getInt(3));
			    	askList.add(askMe);
			    }
				
				
			} catch (SQLException e) {

				e.printStackTrace();
			}		
			
			return askList;
		}
		
}
	


