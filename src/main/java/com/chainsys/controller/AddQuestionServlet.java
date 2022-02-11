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
import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Question;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			QuestionDAOImpl questionDao = new QuestionDAOImpl();
			SectionDAOImpl sectionDao = new SectionDAOImpl();
			String questions = (request.getParameter("question"));
			String sectionName = (request.getParameter("sectionName"));
			int id;
			id = sectionDao.findSectionId(sectionName);
			Question question = new Question(0, questions, id, null);
			questionDao.insertQuestion(question);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
