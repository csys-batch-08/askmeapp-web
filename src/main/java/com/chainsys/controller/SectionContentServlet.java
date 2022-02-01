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

import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.impl.UserRatingDAOImpl;
import com.chainsys.model.Category;
import com.chainsys.model.Section;
import com.chainsys.model.UserRating;


@WebServlet("/SectionContentServlet")
public class SectionContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRatingDAOImpl userRatingDao=new UserRatingDAOImpl();		
		 List<UserRating> userRatingList=userRatingDao.showRating();
			request.setAttribute("userRatingList", userRatingList);
		HttpSession session=request.getSession();
		int sectionId = Integer.parseInt(request.getParameter("secid"));
		String sectionName = request.getParameter("sectionname");
		request.setAttribute("sectionName",sectionName);
		session.setAttribute("sName", sectionName);
		 session.setAttribute("sectionId", sectionId);
		 Section section=new Section(sectionId,null,0,null,null);
		 RequestDispatcher req=request.getRequestDispatcher("sectionContent.jsp");
			req.forward(request, response);
		
	}

}