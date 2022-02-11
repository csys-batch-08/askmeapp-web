package com.chainsys.controller;

import java.io.IOException;
import java.util.List;

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
	 * 
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {
			String name = (request.getParameter("name"));
			String email = (request.getParameter("email"));
			String password = (request.getParameter("password"));
			User Objuser = new User(0, name, email, password, null);
			UserDAOImpl userDao = new UserDAOImpl();
			userDao.insertUser(Objuser);
			response.sendRedirect("login.jsp");
			List<User> userList = null;
			userList = userDao.emailExists(Objuser);
			if (userList == null) {
				userDao.insertUser(Objuser);
				response.sendRedirect("login.jsp");
			}

			else {
				throw new EmailAlreadyExistsException();
			}
		} catch (IOException e1) {

			e1.getMessage();
		}

		catch (EmailAlreadyExistsException e) {
			session.setAttribute("invalid", e.getMessage());

		} catch (Exception e) {

			e.getMessage();
		}
	}

}
