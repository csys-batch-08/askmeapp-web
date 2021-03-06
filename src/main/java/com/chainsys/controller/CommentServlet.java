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

import com.chainsys.impl.CommentDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Comment;
import com.chainsys.model.Question;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			String comment = (request.getParameter("comment"));
			session.setAttribute("comments", comment);
			int userId = Integer.parseInt(session.getAttribute("userid").toString());			
			int catId = Integer.parseInt(session.getAttribute("categoryid").toString());			
			int secId = Integer.parseInt(session.getAttribute("sectionId").toString());			
			CommentDAOImpl commentDao = new CommentDAOImpl();
			Comment commentObj = new Comment(userId, catId, secId, comment);
			commentDao.insertComment(commentObj);			
			Question question = new Question(0, comment, secId, null);
			QuestionDAOImpl questionDao = new QuestionDAOImpl();
			questionDao.insertQuestion(question);			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("commentMessage.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | SQLException e) {
			e.getMessage();
		}
	}
}
