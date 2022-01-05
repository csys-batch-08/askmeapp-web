package com.askme.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.askme.dao.CategoryDAOImpl;
import com.askme.dao.SectionDAOImpl;
import com.askme.model.Category;
import com.askme.model.Section;



/**
 * Servlet implementation class Section
 */
@WebServlet("/SectionServlet")
public class SectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SectionServlet() {
        super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	
	try {
		String sectionName=(request.getParameter("sectionName"));	
		String categoryName=(request.getParameter("categoryName"));	
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();
		int id=CategoryDAOImpl.findCategoryId(categoryName);
		Section section=new Section(sectionName,id);
		SectionDAOImpl sectionDao=new SectionDAOImpl();
		sectionDao.insertSection(section);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("section.jsp");
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


