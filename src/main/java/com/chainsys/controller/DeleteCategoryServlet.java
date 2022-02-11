package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.CategoryDAOImpl;

/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CategoryDAOImpl categoryDao = new CategoryDAOImpl();
			String categoryName = (request.getParameter("CategoryName1"));
			int id = categoryDao.findCategoryId(categoryName);
			System.out.println("category name" + categoryName);
			System.out.println("id" + id);
			String status = categoryDao.findStatus(id);
			System.out.println("status" + status);
			if (status.equals("active")) {
				System.out.println("inactive");
				categoryDao.updateInactive(id);
				response.sendRedirect("admin.jsp");
			} else {
				System.out.println("active ");
				categoryDao.updateActive(id);
				response.sendRedirect("admin.jsp");
			}

		} catch (SQLException e) {

			e.getMessage();
		}

	}

}
