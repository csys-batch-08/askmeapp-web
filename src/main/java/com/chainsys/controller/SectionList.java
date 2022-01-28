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
import com.chainsys.model.Section;
import com.chainsys.model.User;


@WebServlet("/SectionList")
public class SectionList extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		SectionDAOImpl sectionDao=new SectionDAOImpl();
		 HttpSession session=request.getSession();
		   List<Section> sectionList=sectionDao.showAllSection();
			request.setAttribute("sectionList", sectionList);
			RequestDispatcher req=request.getRequestDispatcher("SectionList.jsp");
			req.forward(request, response);
		
       
		

	}

}
