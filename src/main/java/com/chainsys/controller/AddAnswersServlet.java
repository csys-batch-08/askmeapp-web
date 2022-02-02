package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Answer;

/**
 * Servlet implementation class AddAnswersServlet
 */
@WebServlet("/AddAnswersServlet")
public class AddAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
		try {
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		 HttpSession session=request.getSession();		
		String answer=(request.getParameter("answer"));	
		String question=(request.getParameter("question"));	
		int id=questionDao.findQuestionId(question);
		Answer answers=new Answer(answer,id,null);	
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
		
			answerDao.insertAnswer(answers);
			
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("answers.jsp");
		requestDispatcher.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	
	}}

