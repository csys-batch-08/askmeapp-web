package com.chainsys.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.impl.UserDAOImpl;
import com.chainsys.model.Category;
import com.chainsys.model.User;

/**
 * Servlet implementation class category
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();

    }

	public AddCategoryServlet(String categoryName) {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {

		//doGet(request, response);
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	
	try {
		String categoryName=(request.getParameter("categoryName"));			
		Category Objcategory=new Category(0,categoryName,null);
	    CategoryDAOImpl ObjcatDao=new  CategoryDAOImpl();
	   ObjcatDao.insertCategory(Objcategory);
	   
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Categories.jsp");
		requestDispatcher.forward(request, response);
	} catch (ServletException e) {

		e.printStackTrace();
	} 
	
}
	

}
