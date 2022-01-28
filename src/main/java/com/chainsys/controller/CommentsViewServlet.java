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

import com.chainsys.impl.AdminCommentViewDAOImpl;
import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.AdminCommentView;
import com.chainsys.model.User;

/**
 * Servlet implementation class CommentsViewServlet
 */
@WebServlet("/CommentsViewServlet")
public class CommentsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminCommentViewDAOImpl commentDao=new AdminCommentViewDAOImpl();
		HttpSession session=request.getSession();
		List<AdminCommentView> commentList=commentDao.commentView();
		request.setAttribute("commentList", commentList);
		RequestDispatcher req=request.getRequestDispatcher("CommentsView.jsp");
		req.forward(request, response);
		
	}

}
