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

import com.chainsys.exception.AlreadyUsedQuestionException;
import com.chainsys.impl.AskmeDAOImpl;
import com.chainsys.model.AskMe;

/**
 * Servlet implementation class AskQuestion
 */
@WebServlet("/AskQuestionServlet")
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();	
		
	try {
				
		int questionId=Integer.parseInt(session.getAttribute("questionId").toString());	
		System.out.println("qId"+questionId);				
		int userId=Integer.parseInt(session.getAttribute("userid").toString());
		System.out.println("uId"+userId);
		int catId=Integer.parseInt(session.getAttribute("categoryid").toString());
		System.out.println("cId"+catId);
		int secId=Integer.parseInt(session.getAttribute("sectionId").toString());
		System.out.println("sId"+secId);
		AskmeDAOImpl askmeDao=new AskmeDAOImpl();
		AskMe askMe=new AskMe(userId,0,0,questionId);
		List<AskMe> askList=null;
		askList=askmeDao.FindUserId(askMe);
		
		if(askList==null) {
			throw new AlreadyUsedQuestionException();					
			}			
		else {
			AskMe askme=new AskMe(userId,catId,secId,questionId);
			askmeDao.askmequestions(askme);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("userHome.jsp");
			requestDispatcher.forward(request, response);						
		}
		
	}
	catch(AlreadyUsedQuestionException e) {
		try {
			session.setAttribute("invalid", e.getMessage());
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("answer.jsp");
			requestDispatcher.forward(request, response);
			
			}catch (IOException s) {
				e.getMessage();
			}
		
	}
	
	  catch (SQLException e) {

		e.printStackTrace();
	} 
	}

}
