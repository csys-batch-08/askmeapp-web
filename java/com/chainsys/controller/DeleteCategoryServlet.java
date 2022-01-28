package com.chainsys.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.model.Category;

/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
       // response.setContentType("text/html");
	
	
	try {
		
		PrintWriter out=response.getWriter();
		CategoryDAOImpl categoryDao=new  CategoryDAOImpl();
		String categoryName=(request.getParameter("CategoryName1"));	
		int id=categoryDao.findCategoryId(categoryName);
		System.out.println("category name"+categoryName);
		System.out.println("id"+id);
		String status=categoryDao.findStatus(id);
		System.out.println("status"+status);
		if(status.equals("active")) {	
			System.out.println("inactive");
	    categoryDao.updateInactive(id);
	    response.sendRedirect("Categories.jsp");
	    }
		else {
			System.out.println("active ");
			categoryDao.updateActive(id);
			response.sendRedirect("Categories.jsp");
		}
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Categories.jsp");
//		requestDispatcher.forward(request, response);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	}


