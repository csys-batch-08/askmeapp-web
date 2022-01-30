package com.chainsys.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.impl.CommentDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Answer;

/**
 * Servlet implementation class EditAnswerServlet
 */
@WebServlet("/EditAnswerServlet")
public class EditAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

		try {
		HttpSession session=request.getSession();
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		String question=request.getParameter("question");
		//String question=(String) session.getAttribute("questions");
		//System.out.println("question"+question);
		int qId=questionDao.findQuestionId(question);
		//System.out.println("ques"+qId);
		String answer=request.getParameter("answer");
		//System.out.println("ans"+answer);
		Answer answer1=new Answer(answer,qId,null);
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
		answerDao.insertAnswer(answer1);	
		int sId=questionDao.findSectionId(qId);
		System.out.println("SectionId" +sId);
		CommentDAOImpl commentDao=new CommentDAOImpl();
		int commentId=commentDao.findCommentId(sId);
		System.out.println("CommentId"+commentId);
		commentDao.deletedetails(commentId);		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("admin.jsp");
		
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
		
	}

}
