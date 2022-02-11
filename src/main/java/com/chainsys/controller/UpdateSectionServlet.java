package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.model.Section;

/**
 * Servlet implementation class UpdateSectionServlet
 */
@WebServlet("/UpdateSectionServlet")
public class UpdateSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SectionDAOImpl sectionDao = new SectionDAOImpl();
			String sectionName = (request.getParameter("oldSectionName"));
			int id = sectionDao.findSectionId(sectionName);
			String update = (request.getParameter("newSectionName"));
			Section section = new Section(id, update, 0, null, null,null);
			sectionDao.update(section);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | SQLException e) {
			e.getMessage();
		}

	}
}
