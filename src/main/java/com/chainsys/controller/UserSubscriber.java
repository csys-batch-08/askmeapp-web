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

import com.chainsys.impl.SubscribeUserDAOImpl;
import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;

@WebServlet("/UserSubscriber")
public class UserSubscriber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SubscribeUserDAOImpl subscribeDao = new SubscribeUserDAOImpl();
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userid");
			User user = new User(userId, null, null, null, null);
			List<SubscribeUser> subscribeList;
			subscribeList = subscribeDao.showAllSection(user);
			request.setAttribute("subscribeList", subscribeList);
			RequestDispatcher req = request.getRequestDispatcher("subscribeUser.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
