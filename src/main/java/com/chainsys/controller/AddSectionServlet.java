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
import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Section;

/**
 * Servlet implementation class AddSection
 */
@WebServlet("/AddSectionServlet")
public class AddSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			CategoryDAOImpl ObjcatDao = new CategoryDAOImpl();
			SectionDAOImpl sectionDao = new SectionDAOImpl();
			String categoryName = (request.getParameter("selectCategoryName"));
			int id = 0;
			id = ObjcatDao.findCategoryId(categoryName);
			String sectionName = (request.getParameter("sectionName"));
			String image = (request.getParameter("picture"));
			System.out.println("image" + image);
			Section section = new Section(0, sectionName, id, null, image);
			sectionDao.insertSection(section);
			RequestDispatcher req1 = request.getRequestDispatcher("admin.jsp");
			req1.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
