package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Question;

/**
 * Servlet implementation class QuestionList
 */
@WebServlet("/QuestionList")
public class QuestionList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			QuestionDAOImpl questionDao = new QuestionDAOImpl();
			List<Question> questionList;
			questionList = questionDao.showAllQuestion();
			request.setAttribute("questionList", questionList);
			RequestDispatcher req = request.getRequestDispatcher("questionList.jsp");
			req.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
