package com.chainsys.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Question;


/**
 * Servlet implementation class QuestionList
 */
@WebServlet("/QuestionList")
public class QuestionList extends HttpServlet {
	 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		 HttpSession session=request.getSession();
		   List<Question> questionList=questionDao.showAllQuestion();
			request.setAttribute("questionList", questionList);
			RequestDispatcher req=request.getRequestDispatcher("questionList.jsp");
			req.forward(request, response);
		
	}

}
