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
import com.chainsys.model.Category;
import com.chainsys.model.Section;


@WebServlet("/SectionDetailServlet")
public class SectionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cusid"));
		HttpSession session=request.getSession();
		 session.setAttribute("categoryid", cid);
		 Category category =new Category(cid,null,null);
		SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();
		List<Section> sectionList= sectionDAOImpl.showSectionName(category);
		request.setAttribute("sectionList", sectionList);				
		RequestDispatcher req=request.getRequestDispatcher("SectionDetails.jsp");
		req.forward(request, response);
		

 }

}
