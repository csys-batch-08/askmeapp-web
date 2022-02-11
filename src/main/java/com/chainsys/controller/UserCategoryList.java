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

import com.chainsys.impl.CategoryDAOImpl;
import com.chainsys.model.Category;

@WebServlet("/UserCategoryList")
public class UserCategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CategoryDAOImpl categoryDao = new CategoryDAOImpl();
			List<Category> userCategoryList;
			userCategoryList = categoryDao.showAllCategory();
			request.setAttribute("userCategoryList", userCategoryList);
			RequestDispatcher req = request.getRequestDispatcher("homePage.jsp");
			req.forward(request, response);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
