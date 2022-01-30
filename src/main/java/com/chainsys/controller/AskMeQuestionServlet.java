package com.chainsys.controller;

import java.io.IOException;
import java.util.ArrayList;
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
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session=request.getSession();
         QuestionDAOImpl questionDao=new QuestionDAOImpl();
         int id= (int) session.getAttribute("sId");
         System.out.println("sId"+id);
         Section section=new Section(id,null,0,null,null);
         List<Question> questionList=questionDao.showQuestion(section);
         request.setAttribute("questionList", questionList);
         RequestDispatcher req=request.getRequestDispatcher("askQuestion.jsp");
			req.forward(request, response);
         
		
	}

}
