package com.chainsys.controller;

import java.io.IOException;

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
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		HttpSession session=request.getSession();
		String  userId=session.getAttribute("Email").toString();
		System.out.println("user"+userId);
		User user=new User(null,userId,null);
		userDAOImpl.updateSubscribe(user);			
		response.sendRedirect("UserHome.jsp");
	
	}

}
