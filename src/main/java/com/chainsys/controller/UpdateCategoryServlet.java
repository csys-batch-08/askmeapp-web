package com.chainsys.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.model.Category;


/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
		 HttpSession session=request.getSession();
		
	
	try {
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();      
		String oldCategoryName=(request.getParameter("oldCategoryName"));		
		Category Objcategory1=new Category(0,oldCategoryName,null);
		int id=categoryDao.findCategoryId(oldCategoryName);
		String newCategoryName=(request.getParameter("newCategoryName"));		
		Category Objcategory2=new Category(id,newCategoryName,null);	    
	    categoryDao.update(Objcategory2);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("categories.jsp");
		requestDispatcher.forward(request, response);
	} catch (ServletException e) {

		e.printStackTrace();
	} 
	
	
}
	
	}

