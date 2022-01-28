package com.chainsys.dao;

import java.sql.ResultSet;

import com.chainsys.model.Answer;

public interface AnswerDAOInterface {
		public void insertAnswer(Answer answer);
		public void update(String update,int id);
	    public  ResultSet showAllAnswer();	
	    public  ResultSet showAnswer(int quesId);	
		public  int findQuestionId(String answers);
		
		
}
