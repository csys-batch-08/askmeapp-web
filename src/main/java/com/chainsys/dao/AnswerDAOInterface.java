package com.chainsys.dao;

import java.sql.ResultSet;
import java.util.List;

import com.chainsys.model.Answer;

public interface AnswerDAOInterface {
		public void insertAnswer(Answer answer);
		public void update(Answer answer);
	    public  List<Answer> showAllAnswer();	
	    public  ResultSet showAnswer(int quesId);	
		public  int findQuestionId(String answers);
		
		
}
