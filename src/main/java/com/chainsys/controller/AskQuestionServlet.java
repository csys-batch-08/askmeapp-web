package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.exception.AlreadyUsedQuestionException;
import com.chainsys.impl.AskmeDAOImpl;
import com.chainsys.model.AskMe;

/**
 * Servlet implementation class AskQuestion
 */
@WebServlet("/AskQuestionServlet")
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
		
	try {
		HttpSession session=request.getSession();		
		PrintWriter out=response.getWriter();
		int questionId=Integer.parseInt(session.getAttribute("questionId").toString());		
		//String questions=(request.getParameter("question"));		
		int userId=Integer.parseInt(session.getAttribute("userid").toString());
		//System.out.println(userId);
		int catId=Integer.parseInt(session.getAttribute("categoryid").toString());
		//System.out.println(cat_id);
		int secId=Integer.parseInt(session.getAttribute("sectionId").toString());
		AskmeDAOImpl askmeDao=new AskmeDAOImpl();
		AskMe askMe=new AskMe(userId,0,0,questionId);
		List<AskMe> askList=askmeDao.FindUserId(askMe);
		boolean ans=askList.isEmpty();
		if(ans==true) {
				throw new AlreadyUsedQuestionException();			
			}			
		else {
		AskMe askme=new AskMe(userId,catId,secId,questionId);
		askmeDao.askmequestions(askme);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("userHome.jsp");
		requestDispatcher.forward(request, response);}
		
		
	}
	catch(AlreadyUsedQuestionException e) {
		response.sendRedirect("errorMessage.jsp?message="+e.getMessage()+"&url=userHome.jsp");
		
	}
	
	 catch (ServletException e) {

		e.printStackTrace();
	} 
	}

}
