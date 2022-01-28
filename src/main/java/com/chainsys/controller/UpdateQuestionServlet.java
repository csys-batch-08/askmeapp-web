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

import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Question;


/**
 * Servlet implementation class UpdateQuestionServlet
 */
@WebServlet("/UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			QuestionDAOImpl questionDao=new QuestionDAOImpl();
			 HttpSession session=request.getSession();
//			   List<Question> questionList=questionDao.showAllQuestion();
//				request.setAttribute("questionList", questionList);
				
			
			String oldquestion=(request.getParameter("oldquestion"));
			int id=questionDao.findQuestionId(oldquestion);
			String update=(request.getParameter("newquestion"));
			Question question=new Question(id,update,0,null);
			questionDao.update(question);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Question.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} 
	}

}
