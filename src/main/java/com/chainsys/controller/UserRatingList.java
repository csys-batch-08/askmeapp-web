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
import javax.servlet.http.HttpSession;

import com.chainsys.impl.UserRatingDAOImpl;
import com.chainsys.model.UserRating;

/**
 * Servlet implementation class UserRatingList
 */
@WebServlet("/UserRatingList")
public class UserRatingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UserRatingDAOImpl userRatingDao = new UserRatingDAOImpl();
		HttpSession session = request.getSession();
		List<UserRating> userRatingList;
		
			userRatingList = userRatingDao.showRating();
		
		request.setAttribute("userRatingList", userRatingList);
		session.setAttribute("userRating", userRatingList);
		RequestDispatcher req = request.getRequestDispatcher("categoryList.jsp");
		req.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
