package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class category
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {

		
		
		
		
		 try {
	
		HttpSession session=request.getSession();
		String categoryName=(request.getParameter("categoryName"));			
		Category Objcategory=new Category(0,categoryName,null);
	    CategoryDAOImpl ObjcatDao=new  CategoryDAOImpl();
	  
		ObjcatDao.insertCategory(Objcategory);
	
	   
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("categories.jsp");
		
			requestDispatcher.forward(request, response);}
		catch (ServletException | IOException | SQLException e) {

			e.printStackTrace();
		}
	   
	
}
	

}
