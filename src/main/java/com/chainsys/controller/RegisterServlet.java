package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
	
		 	
			PrintWriter out=response.getWriter();			
		
		String name=(request.getParameter("name"));
		String email=(request.getParameter("email"));
		String password=(request.getParameter("password"));		
		User Objuser=new User(0,name,email,password,null);
		UserDAOImpl userDao=new UserDAOImpl();	
		try {
			ResultSet rs=userDao.emailExists(Objuser);	
			if(rs.next()) {
			if(email.equals(rs.getString(3)))
						{
					throw new EmailAlreadyExistsException();
				}
			}
			userDao.insertUser(Objuser);
			response.sendRedirect("login.jsp");}
		
			catch(EmailAlreadyExistsException e)
			{
				response.sendRedirect("errorMessage.jsp?message="+e.getMessage()+"&url=register.jsp");
			}
		
			
		 
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");		
//			requestDispatcher.forward(request, response);
			
		
			catch (SQLException e) {

				e.printStackTrace();
			}
						
			
		
	}

}
