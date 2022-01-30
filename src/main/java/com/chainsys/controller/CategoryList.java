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

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.model.Category;



/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/CategoryList")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();
        HttpSession session=request.getSession();
		   List<Category> categoryList=categoryDao.AllCategory();
			request.setAttribute("categoryList", categoryList);
			
			RequestDispatcher req=request.getRequestDispatcher("categoryList.jsp");
			req.forward(request, response);
	}

}
