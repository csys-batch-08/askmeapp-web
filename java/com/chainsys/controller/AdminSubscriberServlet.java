package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;

/**
 * Servlet implementation class SubscriberServlet
 */
@WebServlet("/SubscriberServlet1")
public class AdminSubscriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSubscriberServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String sectionName=request.getParameter("sectionName");
		SubscribeUser user=new SubscribeUser();
		UserDAOImpl userDao=new UserDAOImpl();		
		List<User> userList = new ArrayList<User>();
		userList=userDao.subscribeUser();
		int id=0;
		boolean flag=false;
		for (User user1: userList ) {
		id=userDao.findUserId(user1.getEmailId());
		SubscribeUser users=new SubscribeUser(id,sectionName);
	    flag=userDao.insertSection(users);
		}
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Sent Message Successfully');");
			out.println("location='Subscriber.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Message not send');");
			out.println("location='Subscriber.jsp';");
			out.println("</script>");

		}

	}

}
