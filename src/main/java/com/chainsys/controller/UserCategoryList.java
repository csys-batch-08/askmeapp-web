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
import com.chainsys.impl.UserRatingDAOImpl;
import com.chainsys.model.Category;
import com.chainsys.model.UserRating;


@WebServlet("/UserCategoryList")
public class UserCategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();
        HttpSession session=request.getSession();
        UserRatingDAOImpl userRatingDao=new UserRatingDAOImpl();		
		 List<UserRating> userRatingList=userRatingDao.showRating();
			request.setAttribute("userRatingList", userRatingList);
			
		   List<Category> userCategoryList=categoryDao.showAllCategory();
			request.setAttribute("userCategoryList", userCategoryList);			
			RequestDispatcher req=request.getRequestDispatcher("homePage.jsp");
			req.forward(request, response);
	}

}
