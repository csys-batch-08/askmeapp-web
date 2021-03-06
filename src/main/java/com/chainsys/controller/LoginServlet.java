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

import com.chainsys.exception.PasswordIncorrect;
import com.chainsys.impl.AdminDAOImpl;
import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.User;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {

			String email = request.getParameter("email");
			session.setAttribute("Email", email);
			String password = request.getParameter("password");

			UserDAOImpl userDao = new UserDAOImpl();
			AdminDAOImpl adminDao = new AdminDAOImpl();

			User currentUser = userDao.validateUser1(email, password);
			User adminUser = adminDao.validateAdmin(email, password);
			if (currentUser != null) {
					int userId = 0;
					userId = userDao.findUserId(email);
					session.setAttribute("userid", userId);
					String subscriber = userDao.findSubscriber(userId);

					if (subscriber.equals("no")) {

						RequestDispatcher requestDispatcher = request.getRequestDispatcher("userHome.jsp");
						requestDispatcher.forward(request, response);
					} else {

						RequestDispatcher requestDispatcher = request.getRequestDispatcher("subscribeMessage.jsp");
						requestDispatcher.forward(request, response);

					}

				}
			 else if (adminUser != null) {

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
					requestDispatcher.forward(request, response);
				}
			

			else {
				throw new PasswordIncorrect();
			}
		}
	
		catch (PasswordIncorrect | SQLException iv) {
			try {
				session.setAttribute("invalid", iv.getMessage());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);

			} catch (IOException s) {
				iv.getMessage();
			}

		}

	}}
