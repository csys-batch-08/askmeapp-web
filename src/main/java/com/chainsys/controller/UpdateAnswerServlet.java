package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.model.Answer;

/**
 * Servlet implementation class UpdateAnswerServlet
 */
@WebServlet("/UpdateAnswerServlet")
public class UpdateAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			AnswerDAOImpl answerDao=new AnswerDAOImpl();
			String oldanswer=(request.getParameter("oldanswer"));
			int id=answerDao.findQuestionId(oldanswer);
			String update=(request.getParameter("newanswer"));
			Answer answer=new Answer(update,id,null);
			answerDao.update(answer);
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Answers.jsp");
			requestDispatcher.forward(request, response);
		} 
	catch (ServletException | SQLException e) {

			e.printStackTrace();
		} 
		
	}

	}


