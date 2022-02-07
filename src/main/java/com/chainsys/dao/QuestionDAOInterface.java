package com.chainsys.dao;



import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.Question;
import com.chainsys.model.Section;

public interface QuestionDAOInterface {
	public void insertQuestion(Question question) throws SQLException ;
	public void update(Question question) throws SQLException;	
	public  int findQuestionId(String quesdes) throws SQLException;	
	public  List<Question> showAllQuestion() throws SQLException;	
	public List<Question> showQuestion(Section section) throws SQLException;
	public int findSectionId(int qId) throws SQLException;
}
