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

import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.User;

/**
 * Servlet implementation class SubscriberList
 */
@WebServlet("/SubscriberList")
public class SubscriberList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDAOImpl userDao = new UserDAOImpl();
			List<User> subscriberList;
			subscriberList = userDao.subscribeUser();
			request.setAttribute("subscriberList", subscriberList);
			RequestDispatcher req = request.getRequestDispatcher("subscriber.jsp");
			req.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
