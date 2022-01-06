package com.askme.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			UserDAOImpl userDao = new UserDAOImpl();
			AdminDAOImpl adminDao=new AdminDAOImpl();
			User currentUser = userDao.validateUser(email, password);
			 try {
				
				if(currentUser==null)
				{
					User adminuser=adminDao.validateAdmin(email, password);					
						//System.out.println("Welcome Admin ");
						//session.setAttribute("LOGGED_IN_ADMIN",adminuser.getName());
					
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("Admin.jsp");
						requestDispatcher.forward(request, response);
						
						
						

				}
					else 
					{   
						//System.out.println("Welcome User ");
						//session.setAttribute("LOGGED_IN_USER",currentUser.getName());
						int user_id=0;
						user_id=userDao.findUserId(email);
						System.out.println(user_id);
						session.setAttribute("userid", user_id);
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserHome.jsp");
						requestDispatcher.forward(request, response);
						
						
					}
					
					
					
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				// TODO Auto-generated catch block
			}
				
		}
	}


