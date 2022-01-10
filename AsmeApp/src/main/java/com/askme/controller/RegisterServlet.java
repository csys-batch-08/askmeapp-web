package com.askme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.askme.exception.EmailAlreadyExistsException;
import com.askme.impl.UserDAOImpl;
import com.askme.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");		
			PrintWriter out=response.getWriter();			
		//doGet(request, response);
		String name=(request.getParameter("name"));
		String email=(request.getParameter("email"));
		String password=(request.getParameter("password"));		
		User Objuser=new User(name,email,password);
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
			response.sendRedirect("Login.jsp");}
		
			catch(EmailAlreadyExistsException e)
			{
				response.sendRedirect("ErrorMessage.jsp?message="+e.getMessage()+"&url=Register.jsp");
			}
		
			
		 
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");		
//			requestDispatcher.forward(request, response);
			
		
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
