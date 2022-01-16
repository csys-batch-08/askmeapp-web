package com.askmeapp.dao;

import java.sql.ResultSet;


import com.askmeapp.model.Answer;

public interface AnswerDAOInterface {
		public void insertAnswer(Answer answer);
		public void update(String update,int id);
		public void deletedetails(String delete) ;
	    public  ResultSet showAllAnswer();	
	    public  ResultSet showAnswer(int quesId);	
		public  int findQuestionId(String answers);
		
		
}
