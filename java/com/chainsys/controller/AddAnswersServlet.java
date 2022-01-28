package com.chainsys.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.AnswerDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Answer;
import com.chainsys.model.Question;

/**
 * Servlet implementation class AddAnswersServlet
 */
@WebServlet("/AddAnswersServlet")
public class AddAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnswersServlet() {
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
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	
	try {
		String answer=(request.getParameter("answer"));	
		String question=(request.getParameter("question"));	
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		int id=questionDao.findQuestionId(question);
		Answer answers=new Answer(answer,id);
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
		answerDao.insertAnswer(answers);	  
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Answers.jsp");
		requestDispatcher.forward(request, response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}

