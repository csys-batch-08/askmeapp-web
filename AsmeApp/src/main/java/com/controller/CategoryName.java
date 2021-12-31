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
import com.askme.dao.UsersDao;
import com.askme.model.Category;
import com.askme.model.User;

/**
 * Servlet implementation class category
 */
@WebServlet("/CategoryName")
public class CategoryName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryName() {
        super();
        // TODO Auto-generated constructor stub
    }

	public CategoryName(String categoryName) {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	//doGet(request, response);
	
	try {
		String categoryName=(request.getParameter("categoryName"));		
		Category Objcategory=new Category(categoryName);
	    CategoryDao ObjcatDao=new  CategoryDao();
	   ObjcatDao.insertCategory(Objcategory);
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
