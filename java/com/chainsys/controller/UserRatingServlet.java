package com.chainsys.controller;

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

import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.impl.UserRatingDAOImpl;


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
		
			
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();		
		PrintWriter out=response.getWriter();	
		String content=(String) session.getAttribute("sectionName");
		//System.out.println(content);
		int newRating=Integer.parseInt(request.getParameter("rating"));
		//System.out.println(newRating);
		SectionDAOImpl sectionDao=new SectionDAOImpl();
		int id=sectionDao.findSectionId(content);
		//System.out.println("sectionid"+id);
	    UserRatingDAOImpl ObjRatDao=new UserRatingDAOImpl();
	    ResultSet rs=ObjRatDao.findRating(content);
	    int oldRating=0;
	    int count=0;
		try {
			while(rs.next()) {
			oldRating = rs.getInt(1);
			count=rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    count=count+1;
	    System.out.println("count"+count);
	    int rating=oldRating+newRating;			
		System.out.println(rating);
	    ObjRatDao.updateRating(rating,count,id);
	    
	    response.sendRedirect("UserHome.jsp");	
		
}}
