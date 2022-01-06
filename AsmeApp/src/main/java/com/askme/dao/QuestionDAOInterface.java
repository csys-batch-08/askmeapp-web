package com.askme.dao;

import java.sql.ResultSet;

import com.askme.model.Question;

public interface QuestionDAOInterface {
	public void insertQuestion(Question question) ;
	public void update(String update,int id);
	public void deletedetails(String delete);	
	public  int findQuestionId(String quesdes);	
	public  ResultSet showAllQuestion();	
		public  ResultSet showQuestion(int id);
		}
