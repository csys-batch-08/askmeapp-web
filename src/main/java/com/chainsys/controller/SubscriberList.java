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

import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.User;

/**
 * Servlet implementation class SubscriberList
 */
@WebServlet("/SubscriberList")
public class SubscriberList extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAOImpl userDao=new UserDAOImpl();		  
		   HttpSession session=request.getSession();
		   List<User> subscriberList=userDao.subscribeUser();
			request.setAttribute("subscriberList", subscriberList);			
			RequestDispatcher req=request.getRequestDispatcher("subscriber.jsp");
			req.forward(request, response);
		
		
	}

}
