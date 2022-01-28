package com.chainsys.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Question;
import com.chainsys.model.Section;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
	SectionDAOImpl sectionDao=new SectionDAOImpl();
	 HttpSession session=request.getSession();
//		   List<Section> sectionList=sectionDao.showAllSection();
//			
//			req.forward(request, response);
	String questions=(request.getParameter("question"));	
	String sectionName=(request.getParameter("sectionName"));	
	int id=sectionDao.findSectionId(sectionName);
	Question question=new Question(0,questions,id,null);
	
	questionDao.insertQuestion(question);	  
	response.sendRedirect("Question.jsp");
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Question.jsp");
//		requestDispatcher.forward(request, response); 
	}

}
