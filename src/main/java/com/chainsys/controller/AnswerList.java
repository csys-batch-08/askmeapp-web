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

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.model.Answer;

@WebServlet("/AnswerList")
public class AnswerList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AnswerDAOImpl answerDao = new AnswerDAOImpl();
			List<Answer> answerList;
			answerList = answerDao.showAllAnswer();
			request.setAttribute("answerList", answerList);
			RequestDispatcher req = request.getRequestDispatcher("answersList.jsp");
			req.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
