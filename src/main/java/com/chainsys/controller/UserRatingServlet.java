package com.chainsys.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.impl.UserRatingDAOImpl;
import com.chainsys.model.Section;
import com.chainsys.model.UserRating;


/**
 * Servlet implementation class UserRatingSection
 */
@WebServlet("/UserRatingServlet")
public class UserRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session=request.getSession();		
		PrintWriter out=response.getWriter();	
		UserRating userRating=new UserRating();
		String content=request.getParameter("sName");
		//String content=(String) session.getAttribute("sName");
		System.out.println("sName"+content);
		session.setAttribute("sectionName", content);
		int newRating=Integer.parseInt(request.getParameter("rating"));
		System.out.println(newRating);
		SectionDAOImpl sectionDao=new SectionDAOImpl();
		int id=sectionDao.findSectionId(content);
		System.out.println("sectionid"+id);
		session.setAttribute("sid",id);
	    UserRatingDAOImpl ObjRatDao=new UserRatingDAOImpl();
	    Section section=new Section(0,content,0,null,null);
	    List<UserRating> userRateList=ObjRatDao.findRating(section);
	    int oldRating=0;
	    int count=0;
		for(int i=0;i<userRateList.size();i++) {
			oldRating = userRateList.get(i).getRating();
			System.out.println("or"+oldRating);
			count=userRateList.get(i).getRateCount();	
			System.out.println("oc"+count);
			count=count+1;
			System.out.println("count"+count);
		    int rating=oldRating+newRating;			
			System.out.println(rating);
			userRating=new UserRating(content,0,rating,count);
		    ObjRatDao.updateRating(userRating);
			}
		
	    
		
	    RequestDispatcher requestDispatcher=request.getRequestDispatcher("userHome.jsp");
		requestDispatcher.forward(request, response);
	     
		
}}
