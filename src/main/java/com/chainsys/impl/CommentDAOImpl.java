package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.CommentDAOInterface;
import com.chainsys.model.Comment;
import com.chainsys.util.ConnectionUtil;

public class CommentDAOImpl implements CommentDAOInterface {

	@Override
	public void insertComment(Comment comment) throws SQLException {
		// Query-insert User
		String insertQuery = "insert into comment_by_user(user_id,category_id,section_id,comments) values(?,?,?,?)";
		// DB connection

		Connection con = null;
		PreparedStatement pst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, comment.getUserId());
			pst.setInt(2, comment.getCategoryId());
			pst.setInt(3, comment.getSectionId());
			pst.setString(4, comment.getComments());
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

	// List of User
	@Override
	public List<Comment> showAllComment() throws SQLException {
		String selectQuery = "select user_id,comments from comment_by_user";
		List<Comment> commentList = new ArrayList<>();

		Connection con = null;

		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(selectQuery);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setUserId(rs.getInt(1));
				comment.setComments(rs.getString(2));
				commentList.add(comment);
			}

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

		return commentList;
	}

	// Find comment Id
	@Override
	public int findCommentId(int sectionId) throws SQLException {
		String findUserId = "select comment_id from comment_by_user where section_id='" + sectionId + "'";
		Connection con = null;
		PreparedStatement pstmt = null;

		int commentId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(findUserId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				commentId = rs.getInt(1);
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
		return commentId;

	}

	// Delete
	@Override
	public void deletedetails(int commentId) throws SQLException {
		String deleteQuery = "delete from comment_by_user where comment_id=?";
		// get connection
		Connection con = null;

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, commentId);
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

}
