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
import javax.servlet.http.HttpSession;

import com.askme.exception.EmailAlreadyExistsException;
import com.askme.exception.PasswordIncorrect;
import com.askme.impl.AdminDAOImpl;
import com.askme.impl.UserDAOImpl;
import com.askme.model.User;


/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 PrintWriter out=response.getWriter();
	        HttpSession session=request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user=new User(null,email,password);
			UserDAOImpl userDao = new UserDAOImpl();
			AdminDAOImpl adminDao=new AdminDAOImpl();
			ResultSet rs;
			try {
			User currentUser=userDao.validateUser1(email, password);
			User adminUser=adminDao.validateAdmin(email, password);
			if(currentUser!=null) {
				if(email.equals(currentUser.getEmailId()) && password.equals(currentUser.getPassword()))
					{
							int user_id=0;
							user_id=userDao.findUserId(email);
			//				System.out.println(user_id);
							session.setAttribute("userid", user_id);
							RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserHome.jsp");
							requestDispatcher.forward(request, response);}
				
			}
			else if(adminUser!=null)
			{
				if(email.equals(adminUser.getEmailId()) && password.equals(adminUser.getPassword()))
				{
					
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("Admin.jsp");
					requestDispatcher.forward(request, response);
			}
			}
				

			else {
				throw new PasswordIncorrect();
			}}
				
			catch(PasswordIncorrect iv) {

				response.sendRedirect("ErrorMessage.jsp?message="+iv.getMessage()+"&url=Login.jsp");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
}	
				
		
	


