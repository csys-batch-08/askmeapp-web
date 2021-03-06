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

import com.chainsys.dao.AnswerDAOInterface;
import com.chainsys.model.Answer;
import com.chainsys.model.Question;
import com.chainsys.util.ConnectionUtil;

public class AnswerDAOImpl implements AnswerDAOInterface {
	// insert
	@Override
	public void insertAnswer(Answer answer) throws SQLException {
		// Query-insert
		String insertQuery = "insert into answer(answers,question_id) values(?,?)";
		// DB connection
		Connection con = null;
		PreparedStatement pste = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pste = con.prepareStatement(insertQuery);
			pste.setString(1, answer.getAnswers());
			pste.setInt(2, answer.getQuestionId());
			pste.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();

		} finally {
			if (pste != null) {
				pste.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// Update
	@Override
	public void update(Answer answer) throws SQLException {
		String updateQuery = "update answer set answers=? where question_id=?";
		// get connection
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, answer.getAnswers());
			pstmt.setInt(2, answer.getQuestionId());
			pstmt.executeUpdate();
			

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

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

	// Show All
	@Override
	public List<Answer> showAllAnswer() throws SQLException {

		List<Answer> answerList = new ArrayList<>();

		String selectQuery = "select answers,status from answer";

		Connection con = null;
		PreparedStatement pstmte = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmte = con.prepareStatement(selectQuery);
			rs = pstmte.executeQuery();
			while (rs.next()) {
				Answer answer = new Answer();
				answer.setAnswers(rs.getString(1));
				answer.setStatus(rs.getString(2));
				answerList.add(answer);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (pstmte != null) {
				pstmte.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return answerList;
	}

	@Override
	public List<Answer> showAnswer(Question question) throws SQLException {

		List<Answer> answerList = new ArrayList<>();

		String query = "select answers from answer where question_id=? and status='active'";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, question.getQuestionId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Answer answer = new Answer();
				answer.setAnswers(rs.getString(1));
				answerList.add(answer);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return answerList;
	}

	@Override
	public int findQuestionId(String answers) throws SQLException {
		String findUserId = "select question_id from answer where answers=?";
		Connection con = null;
		PreparedStatement stmtm = null;
		ResultSet rs = null;
		int questionId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmtm = con.prepareStatement(findUserId);
			stmtm.setString(1, answers);
			rs = stmtm.executeQuery();
			if (rs.next()) {
				questionId = rs.getInt(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (stmtm != null) {
				stmtm.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return questionId;

	}

}
