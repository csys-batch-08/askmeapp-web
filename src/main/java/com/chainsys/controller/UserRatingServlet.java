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

import com.chainsys.impl.SectionDAOImpl;
import com.chainsys.impl.UserRatingDAOImpl;
import com.chainsys.model.Section;
import com.chainsys.model.UserRating;

/**
 * Servlet implementation class UserRatingSection
 */
@WebServlet("/UserRatingServlet")
public class UserRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			UserRating userRating;
			String content = request.getParameter("sName");
			session.setAttribute("sectionName", content);
			int newRating = Integer.parseInt(request.getParameter("rating"));
			SectionDAOImpl sectionDao = new SectionDAOImpl();
			int id;
			id = sectionDao.findSectionId(content);
			session.setAttribute("sid", id);
			UserRatingDAOImpl objRatDao = new UserRatingDAOImpl();
			Section section = new Section(0, content, 0, null, null,null);
			List<UserRating> userRateList = objRatDao.findRating(section);
			int oldRating = 0;
			int count = 0;
			for (int i = 0; i < userRateList.size(); i++) {
				oldRating = userRateList.get(i).getRating();
				count = userRateList.get(i).getRateCount();
				count = count + 1;
				int rating = oldRating + newRating;
				userRating = new UserRating(content, 0, rating, count);
				objRatDao.updateRating(userRating);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userHome.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.getMessage();
		}

	}
}
