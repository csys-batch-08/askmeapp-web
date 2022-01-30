package com.chainsys.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Answer;
import com.chainsys.model.Question;

/**
 * Servlet implementation class AddAnswersServlet
 */
@WebServlet("/AddAnswersServlet")
public class AddAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//try {
		
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		 HttpSession session=request.getSession();
//		   List<Question> questionList=questionDao.showAllQuestion();
//			request.setAttribute("questionList", questionList);
			
			
		String answer=(request.getParameter("answer"));	
		String question=(request.getParameter("question"));	
		int id=questionDao.findQuestionId(question);
		Answer answers=new Answer(answer,id,null);	
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
		answerDao.insertAnswer(answers);	
		response.sendRedirect("answers.jsp");
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Answers.jsp");
//		requestDispatcher.forward(request, response);
		
//	} 
//		catch (ServletException e) {
//
//		e.printStackTrace();
//	} 
	}
	}

