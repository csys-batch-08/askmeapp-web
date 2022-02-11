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
import javax.servlet.http.HttpSession;

import com.chainsys.exception.AlreadyUsedQuestionException;
import com.chainsys.impl.AskmeDAOImpl;
import com.chainsys.model.AskMe;

/**
 * Servlet implementation class AskQuestion
 */
@WebServlet("/AskQuestionServlet")
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int questionId = (int)(session.getAttribute("questionId"));			
			int userId = (int)(session.getAttribute("userid"));	
			int catId = (int)(session.getAttribute("categoryid"));			
			int secId = (int)(session.getAttribute("sectionId"));			
			AskmeDAOImpl askmeDao = new AskmeDAOImpl();
			AskMe askMe = new AskMe(userId, 0, 0, questionId);
			List<AskMe> askList = null;
			askList = askmeDao.findUserId(askMe);
			if (askList == null) {
				throw new AlreadyUsedQuestionException();
			} else {
				AskMe askme = new AskMe(userId, catId, secId, questionId);
				askmeDao.askmequestions(askme);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("userHome.jsp");
				requestDispatcher.forward(request, response);
			}

		} catch (AlreadyUsedQuestionException e) {
			try {
				session.setAttribute("invalid", e.getMessage());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("answer.jsp");
				requestDispatcher.forward(request, response);

			} catch (IOException s) {
				e.getMessage();
			}

		}

		catch (SQLException e) {
			e.getMessage();
		}
	}

}
