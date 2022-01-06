package com.askme.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.askme.impl.AskmeDAOImpl;
import com.askme.impl.QuestionDAOImpl;
import com.askme.impl.SectionDAOImpl;
import com.askme.model.AskMe;
import com.askme.model.Question;

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
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();		}
	
	try {
		String questions=(request.getParameter("question"));	
		int user_Id=Integer.parseInt(session.getAttribute("userid").toString());
		//System.out.println(user_Id);
		int cat_id=Integer.parseInt(session.getAttribute("category_id").toString());
		//System.out.println(cat_id);
		int sec_id=Integer.parseInt(session.getAttribute("secid").toString());
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		int question_id=questionDao.findQuestionId(questions);
		System.out.println(question_id);
		AskmeDAOImpl askmeDao=new AskmeDAOImpl();
		AskMe askme=new AskMe(user_Id,cat_id,sec_id,question_id);
		askmeDao.askmequestions(askme);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserHome.jsp");
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
