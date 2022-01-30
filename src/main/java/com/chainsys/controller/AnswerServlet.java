package com.chainsys.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Answer;
import com.chainsys.model.Question;
import com.chainsys.model.Section;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
         AnswerDAOImpl answerDao=new AnswerDAOImpl();
         int qId=Integer.parseInt(request.getParameter("quesId"));
         session.setAttribute("questionId", qId);
         String ques=request.getParameter("question");
         session.setAttribute("question", ques);
         Question question=new Question(qId,null,0,null);
         List<Answer> answerList=answerDao.showAnswer(question);
         request.setAttribute("answerList", answerList);
         RequestDispatcher req=request.getRequestDispatcher("answer.jsp");
			req.forward(request, response);
	}

}
