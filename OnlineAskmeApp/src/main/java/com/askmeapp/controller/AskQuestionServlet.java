package com.askmeapp.controller;

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

import com.askmeapp.exception.AlreadyUsedQuestionException;
import com.askmeapp.impl.AskmeDAOImpl;
import com.askmeapp.model.AskMe;

/**
 * Servlet implementation class AskQuestion
 */
@WebServlet("/AskQuestionServlet")
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 HttpSession session=request.getSession();		
			PrintWriter out=response.getWriter();
		
	try {
		int question_id=Integer.parseInt(session.getAttribute("quesId").toString());		
		//String questions=(request.getParameter("question"));		
		int user_Id=Integer.parseInt(session.getAttribute("userid").toString());
		System.out.println(user_Id);
		int cat_id=Integer.parseInt(session.getAttribute("category_id").toString());
		//System.out.println(cat_id);
		int sec_id=Integer.parseInt(session.getAttribute("secid").toString());
		AskmeDAOImpl askmeDao=new AskmeDAOImpl();
		ResultSet rs=askmeDao.FindUserId(user_Id,question_id);
		if(rs.next()) {
				throw new AlreadyUsedQuestionException();			
			}			
		else {
		AskMe askme=new AskMe(user_Id,cat_id,sec_id,question_id);
		askmeDao.askmequestions(askme);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserHome.jsp");
		requestDispatcher.forward(request, response);}
		
		
	}
	catch(AlreadyUsedQuestionException e) {
		response.sendRedirect("ErrorMessage.jsp?message="+e.getMessage()+"&url=UserHome.jsp");
		
	}
	
	 catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
