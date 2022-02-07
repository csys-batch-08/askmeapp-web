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

import com.chainsys.exception.EmailAlreadyExistsException;
import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
		String name = (request.getParameter("name"));
		String email = (request.getParameter("email"));
		String password = (request.getParameter("password"));
		User Objuser = new User(0, name, email, password, null);
		UserDAOImpl userDao = new UserDAOImpl();
		try {
			List<User> userList = null;
			userList = userDao.emailExists(Objuser);
			if (userList != null) {
				throw new EmailAlreadyExistsException();
			} else {
				userDao.insertUser(Objuser);
				response.sendRedirect("login.jsp");
			}
		} catch (EmailAlreadyExistsException e) {
			try {
				session.setAttribute("invalid",e.getMessage());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (IOException s) {
				e.getMessage();
			} catch (ServletException e1) {
				
				e1.printStackTrace();
			}
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
