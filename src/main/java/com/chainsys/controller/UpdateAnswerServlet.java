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
import com.chainsys.model.Answer;

/**
 * Servlet implementation class UpdateAnswerServlet
 */
@WebServlet("/UpdateAnswerServlet")
public class UpdateAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//try {
			AnswerDAOImpl answerDao=new AnswerDAOImpl();
			HttpSession session=request.getSession();
//			List<Answer> answerList=answerDao.showAllAnswer();
//			request.setAttribute("answerList", answerList);
			
			
			String oldanswer=(request.getParameter("oldanswer"));
			int id=answerDao.findQuestionId(oldanswer);
			String update=(request.getParameter("newanswer"));
			Answer answer=new Answer(update,id,null);
			answerDao.update(answer);
			response.sendRedirect("Answers.jsp");
//			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Answers.jsp");
//			requestDispatcher.forward(request, response);
		} 
//	catch (ServletException e) {
//
//			e.printStackTrace();
//		} 
//		
//	}

	}


