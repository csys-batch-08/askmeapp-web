package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.User;

/**
 * Servlet implementation class SubscribeServlet
 */

@WebServlet("/SubscribeServle1")
public class SubscribeServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	  
		HttpSession session = request.getSession();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		String userId = session.getAttribute("Email").toString();
		System.out.println("user" + userId);
		User user = new User(0, null, userId, null, null);		
			userDAOImpl.updateSubscribe(user);		
		response.sendRedirect("userHome.jsp");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
