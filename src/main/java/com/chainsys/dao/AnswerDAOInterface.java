package com.chainsys.dao;



import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.Answer;
import com.chainsys.model.Question;

public interface AnswerDAOInterface {
		public void insertAnswer(Answer answer)throws SQLException;
		public void update(Answer answer) throws SQLException;
	    public  List<Answer> showAllAnswer() throws SQLException;	
	    public List<Answer> showAnswer(Question question) throws SQLException;	
		public  int findQuestionId(String answers) throws SQLException;
		
		
}
