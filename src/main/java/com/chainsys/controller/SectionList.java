package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Section;


@WebServlet("/SectionList")
public class SectionList extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
		SectionDAOImpl sectionDao = new SectionDAOImpl();
		List<Section> sectionList;	
			sectionList = sectionDao.showAllSection();		
		request.setAttribute("sectionList", sectionList);
		RequestDispatcher req = request.getRequestDispatcher("sectionList.jsp");
		req.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
