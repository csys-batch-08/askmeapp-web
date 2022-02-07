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

import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Question;
import com.chainsys.model.Section;

/**
 * Servlet implementation class AskMeQuestionServlet
 */
@WebServlet("/AskMeQuestionServlet")
public class AskMeQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session=request.getSession();
         System.out.println("helo");
         QuestionDAOImpl questionDao=new QuestionDAOImpl();
         int secId=Integer.parseInt(session.getAttribute("sectionId").toString());
         System.out.println("sId"+secId);
         Section section=new Section(secId,null,0,null,null);
         List<Question> questionList;
		
			questionList = questionDao.showQuestion(section);
	
         request.setAttribute("questionList", questionList);
         RequestDispatcher req=request.getRequestDispatcher("askQuestion.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
         
		
	}

}
