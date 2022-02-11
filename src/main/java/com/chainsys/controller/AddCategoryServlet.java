package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.model.Category;

/**
 * Servlet implementation class category
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String categoryName = (request.getParameter("categoryName"));
			Category objCategory = new Category(0, categoryName, null,null);
			CategoryDAOImpl objCatDao = new CategoryDAOImpl();
			objCatDao.insertCategory(objCategory);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			e.getMessage();
		}

	}

}
