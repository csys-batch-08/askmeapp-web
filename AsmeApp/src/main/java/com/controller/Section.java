package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.askme.dao.CategoryDao;
import com.askme.dao.SectionDao;
import com.askme.model.Category;
import com.askme.model.Section1;



/**
 * Servlet implementation class Section
 */
@WebServlet("/Section")
public class Section extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Section() {
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
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	//doGet(request, response);
	
	try {
		String sectionName=(request.getParameter("sectionName"));	
		String categoryName=(request.getParameter("categoryName"));	
		CategoryDao categoryDao=new CategoryDao();
		int id=CategoryDao.findCategoryId(categoryName);
		Section1 section=new Section1(sectionName,id);
		SectionDao sectionDao=new SectionDao();
		sectionDao.insertSection(section);
	   
	  
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Register.jsp");
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


