package com.chainsys.dao;

import java.sql.ResultSet;

import com.chainsys.model.Question;

public interface QuestionDAOInterface {
	public void insertQuestion(Question question) ;
	public void update(String update,int id);	
	public  int findQuestionId(String quesdes);	
	public  ResultSet showAllQuestion();	
	public  ResultSet showQuestion(int id);
}
