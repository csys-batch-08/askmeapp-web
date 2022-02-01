package com.chainsys.dao;



import java.util.List;

import com.chainsys.model.Answer;
import com.chainsys.model.Question;

public interface AnswerDAOInterface {
		public void insertAnswer(Answer answer);
		public void update(Answer answer);
	    public  List<Answer> showAllAnswer();	
	    public List<Answer> showAnswer(Question question);	
		public  int findQuestionId(String answers);
		
		
}
