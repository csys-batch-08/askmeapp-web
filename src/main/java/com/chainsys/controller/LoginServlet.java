package com.chainsys.controller;
import java.io.IOException;



import java.io.PrintWriter;

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
@WebServlet("/LoginServlet1")



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		 try {
			PrintWriter out=response.getWriter();
		
	        HttpSession session=request.getSession();
			String email = request.getParameter("email");
			session.setAttribute("Email", email);
			String password = request.getParameter("password");
			User user=new User(0,null,email,password,null);
			UserDAOImpl userDao = new UserDAOImpl();
			AdminDAOImpl adminDao=new AdminDAOImpl();
			
			
			User currentUser=userDao.validateUser1(email, password);
			User adminUser=adminDao.validateAdmin(email, password);
			if(currentUser!=null) {
				if(email.equals(currentUser.getEmailId()) && password.equals(currentUser.getPassword()))
					{
							int user_id=0;
							user_id=userDao.findUserId(email);						
							session.setAttribute("userid", user_id);
							String subscriber=userDao.findSubscriber(user_id);
							
							if(subscriber.equals("no")) {
								
								RequestDispatcher requestDispatcher=request.getRequestDispatcher("userHome.jsp");
							requestDispatcher.forward(request, response);
							}
							else {
								
							RequestDispatcher requestDispatcher=request.getRequestDispatcher("subscribeMessage.jsp");
						requestDispatcher.forward(request, response);
								
										
																	
							}
								
							}
			}
			else if(adminUser!=null)
			{
				if(email.equals(adminUser.getEmailId()) && password.equals(adminUser.getPassword()))
				{
					
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("admin.jsp");
					requestDispatcher.forward(request, response);
			}
			}
				

			else {
				throw new PasswordIncorrect();
			}
		 } catch (IOException e1) {

				e1.printStackTrace();
			}
				
			catch(PasswordIncorrect iv) {
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("ErrorMessage.jsp?message="+iv.getMessage()+"&url=Login.jsp");
				requestDispatcher.forward(request, response);

				
		
		} catch (Exception e) {

			e.printStackTrace();
			}
	}
	
}	
				
		
	


