package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.CommentDAOImpl;
import com.chainsys.impl.QuestionDAOImpl;
import com.chainsys.model.Comment;
import com.chainsys.model.Question;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
			String comment=(request.getParameter("comment"));	
			session.setAttribute("comments", comment);
			int user_Id=Integer.parseInt(session.getAttribute("userid").toString());
			//System.out.println(user_Id);
			int cat_id=Integer.parseInt(session.getAttribute("category_id").toString());
			//System.out.println(cat_id);
			int sec_id=Integer.parseInt(session.getAttribute("secid").toString());
			//System.out.println(sec_id);
			CommentDAOImpl commentDao=new CommentDAOImpl();
			Comment commentObj=new Comment(user_Id,cat_id,sec_id,comment);
			commentDao.insertComment(commentObj);
			//System.out.println("Comment inserted");
			Question question=new Question(0,comment,sec_id,null);
			QuestionDAOImpl questionDao=new QuestionDAOImpl();
			questionDao.insertQuestion(question);
			//System.out.println("Question inserted");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("CommentMessage.jsp");
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


