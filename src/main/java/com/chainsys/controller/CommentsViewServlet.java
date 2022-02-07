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

import com.chainsys.impl.AdminCommentViewDAOImpl;
import com.chainsys.model.AdminCommentView;

/**
 * Servlet implementation class CommentsViewServlet
 */
@WebServlet("/CommentsViewServlet")
public class CommentsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AdminCommentViewDAOImpl commentDao = new AdminCommentViewDAOImpl();
			List<AdminCommentView> commentList;
			commentList = commentDao.commentView();
			request.setAttribute("commentList", commentList);
			RequestDispatcher req = request.getRequestDispatcher("commentsView.jsp");
			req.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
