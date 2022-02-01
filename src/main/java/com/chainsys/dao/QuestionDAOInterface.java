package com.chainsys.dao;



import java.util.List;

import com.chainsys.model.Question;
import com.chainsys.model.Section;

public interface QuestionDAOInterface {
	public void insertQuestion(Question question) ;
	public void update(Question question);	
	public  int findQuestionId(String quesdes);	
	public  List<Question> showAllQuestion();	
	public List<Question> showQuestion(Section section);
}
