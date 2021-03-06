package com.chainsys.impl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

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
		PreparedStatement pstt = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pstt = con.prepareStatement(insertQuery);
			pstt.setString(1, question.getQuestions());
			pstt.setInt(2, question.getSectionId());
			pstt.executeUpdate();
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.getMessage();
		} finally {
			if (pstt != null) {
				pstt.close();
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
		PreparedStatement psstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			psstmt = con.prepareStatement(updateQuery);
			psstmt.setString(1, question.getQuestions());
			psstmt.setInt(2, question.getQuestionId());
			psstmt.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.getMessage();
		} finally {

			if (psstmt != null) {
				psstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// Find
	@Override
	public int findQuestionId(String quesdes) throws SQLException {
		String findUserId = "select question_id from question_details where question_description=?";
		Connection con = null;
		PreparedStatement stmmt = null;
		ResultSet rs = null;
		int questionId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmmt = con.prepareStatement(findUserId);
			stmmt.setString(1, quesdes);
			rs = stmmt.executeQuery();
			if (rs.next()) {
				questionId = rs.getInt(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (stmmt != null) {
				stmmt.close();
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

		List<Question> questionList = new ArrayList<>();
		String selectQuery = "select question_id,question_description,status from question_details";
		Connection con = null;
		PreparedStatement ptstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			ptstmt = con.prepareStatement(selectQuery);
			rs = ptstmt.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionId(rs.getInt(1));
				question.setQuestions(rs.getString(2));
				question.setStatus(rs.getString(3));
				questionList.add(question);
			}
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (ptstmt != null) {
				ptstmt.close();
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

		List<Question> questionList = new ArrayList<>();

		String query = "select question_id,question_description from question_details where section_id=? and status='active'";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstm = con.prepareStatement(query);
			pstm.setInt(1, section.getSectionId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionId(rs.getInt(1));
				question.setQuestions(rs.getString(2));

				questionList.add(question);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (pstm != null) {
				pstm.close();
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
		String findUserId = "select section_id from question_details where question_id=?";
		Connection con = null;
		PreparedStatement stmte = null;
		ResultSet rs = null;
		int sectionId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmte = con.prepareStatement(findUserId);
			stmte.setInt(1, qId);
			rs = stmte.executeQuery();
			if (rs.next()) {
				sectionId = rs.getInt(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (stmte != null) {
				stmte.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return sectionId;

	}

}
