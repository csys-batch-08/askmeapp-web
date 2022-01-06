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

import com.askme.impl.CategoryDAOImpl;
import com.askme.impl.SectionDAOImpl;
import com.askme.impl.UserRatingDAOImpl;
import com.askme.model.Category;
import com.askme.model.UserRating;


/**
 * Servlet implementation class UserRatingSection
 */
@WebServlet("/UserRatingServlet")
public class UserRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	try {
		String content=(String) session.getAttribute("sectionName");
		//System.out.println(content);
		int newRating=Integer.parseInt(request.getParameter("rating"));
		//System.out.println(newRating);
		SectionDAOImpl sectionDao=new SectionDAOImpl();
		int id=sectionDao.findSectionId(content);
		//System.out.println("sectionid"+id);
	    UserRatingDAOImpl ObjRatDao=new UserRatingDAOImpl();
	    int oldRating=ObjRatDao.findRating(content);
	    //System.out.println(oldRating);
	    int rating=oldRating+newRating;
	    //System.out.println("update"+rating);
	    ObjRatDao.updateRating(rating,id);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Logout.jsp");
		requestDispatcher.forward(request, response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
}}
