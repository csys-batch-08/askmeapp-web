package com.chainsys.dao;

import java.sql.ResultSet;
import java.util.List;

import com.chainsys.model.Question;

public interface QuestionDAOInterface {
	public void insertQuestion(Question question) ;
	public void update(Question question);	
	public  int findQuestionId(String quesdes);	
	public  List<Question> showAllQuestion();	
	public  ResultSet showQuestion(int id);
}
