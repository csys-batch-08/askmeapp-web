package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.QuestionDAOInterface;
import com.chainsys.model.Question;
import com.chainsys.model.Section;
import com.chainsys.util.ConnectionUtil;

public class QuestionDAOImpl implements QuestionDAOInterface {

	@Override
	public void insertQuestion(Question question) throws SQLException {
		// Query-insert
		String insertQuery = "insert into question_details(question_description,section_id) values(?,?)";
		// DB connection
		Connection con = null;
		PreparedStatement pst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, question.getQuestions());
			pst.setInt(2, question.getSectionId());
			pst.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();

		} finally {

			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// Update
	@Override
	public void update(Question question) throws SQLException {
		String updateQuery = "update question_details set question_description=? where question_id=?";
		// get connection
		Connection con = null;

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, question.getQuestions());
			pstmt.setInt(2, question.getQuestionId());
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();
		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// Find
	@Override
	public int findQuestionId(String quesdes) throws SQLException {
		String findUserId = "select question_id from question_details where question_description='" + quesdes + "'";
		Connection con = null;
		PreparedStatement stmt = null;

		int questionId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findUserId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				questionId = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {

			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return questionId;

	}

	// List
	@Override
	public List<Question> showAllQuestion() throws SQLException {

		List<Question> questionList = new ArrayList<Question>();

		String selectQuery = "select question_id,question_description,status from question_details";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionId(rs.getInt(1));
				question.setQuestions(rs.getString(2));
				question.setStatus(rs.getString(3));
				questionList.add(question);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return questionList;
	}

	// Search by Question

	@Override
	public List<Question> showQuestion(Section section) throws SQLException {

		List<Question> questionList = new ArrayList<Question>();

		String query = "select question_id,question_description from question_details where section_id=? and status='active'";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, section.getSectionId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionId(rs.getInt(1));
				question.setQuestions(rs.getString(2));

				questionList.add(question);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return questionList;
	}

	// Find section Id
	@Override
	public int findSectionId(int qId) throws SQLException {
		String findUserId = "select section_id from question_details where question_id='" + qId + "'";
		Connection con = null;
		PreparedStatement stmt = null;

		int sectionId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findUserId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sectionId = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {

			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return sectionId;

	}

}
