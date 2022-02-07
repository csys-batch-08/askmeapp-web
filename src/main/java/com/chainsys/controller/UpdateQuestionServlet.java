package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Question;


/**
 * Servlet implementation class UpdateQuestionServlet
 */
@WebServlet("/UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
			QuestionDAOImpl questionDao = new QuestionDAOImpl();
			String oldquestion = (request.getParameter("oldquestion"));
			int id = questionDao.findQuestionId(oldquestion);
			String update = (request.getParameter("newquestion"));
			Question question = new Question(id, update, 0, null);
			questionDao.update(question);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
