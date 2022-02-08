package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;

/**
 * Servlet implementation class SubscriberServlet
 */
@WebServlet("/SubscriberServlet1")
public class AdminSubscriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String sectionName = request.getParameter("sectionName");
			UserDAOImpl userDao = new UserDAOImpl();
			List<User> userList = new ArrayList<User>();
			userList = userDao.subscribeUser();
			int id = 0;
			boolean flag = false;
			for (User user1 : userList) {
				id = userDao.findUserId(user1.getEmailId());
				SubscribeUser users = new SubscribeUser(id, sectionName);
				flag = userDao.insertSection(users);
			}
			if (flag) {
				session.setAttribute("message", "Sent Message Successfully");
				RequestDispatcher req = request.getRequestDispatcher("admin.jsp");
				req.forward(request, response);

			} else {
				session.setAttribute("message", "Message not send");
				RequestDispatcher req = request.getRequestDispatcher("subscriber.jsp");
				req.forward(request, response);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
