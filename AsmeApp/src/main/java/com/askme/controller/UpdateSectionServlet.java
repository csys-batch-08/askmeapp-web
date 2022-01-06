package com.askme.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.askme.impl.CategoryDAOImpl;
import com.askme.impl.SectionDAOImpl;
import com.askme.model.Category;


/**
 * Servlet implementation class UpdateSectionServlet
 */
@WebServlet("/UpdateSectionServlet")
public class UpdateSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        response.setContentType("text/html");		
		try {
			PrintWriter out=response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	
	try {
		SectionDAOImpl sectionDao=new  SectionDAOImpl();
		String sectionName=(request.getParameter("oldSectionName"));
		int id=sectionDao.findSectionId(sectionName);
		String update=(request.getParameter("newSectionName"));;
		sectionDao.update(update,id);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Section.jsp");
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


