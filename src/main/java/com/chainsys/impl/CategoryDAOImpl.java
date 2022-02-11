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

import com.chainsys.dao.CategoryDAOInterface;
import com.chainsys.model.Category;
import com.chainsys.util.ConnectionUtil;

public class CategoryDAOImpl implements CategoryDAOInterface {
	@Override
	public void insertCategory(Category category) throws SQLException {
		// insert
		String insertQuery = "insert into category_detail(category_name) values(?)";
		// DB connection
		Connection con = null;
		PreparedStatement pstm = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pstm = con.prepareStatement(insertQuery);
			pstm.setString(1, category.getCategoryName());
			pstm.executeUpdate();

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

	}

	// Update
	@Override
	public void update(Category category) throws SQLException {
		String updateQuery = "update category_detail set category_name=?  where category_id=?";
		// get connection
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, category.getCategoryName());
			pstmt.setInt(2, category.getCategoryId());
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

	// Find
	@Override
	public int findCategoryId(String categoryName) throws SQLException {
		String findUserId = "select category_id from category_detail where category_name=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int categoryId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findUserId);
			stmt.setString(1, categoryName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				categoryId = rs.getInt(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}

		}
		return categoryId;

	}

	// Update Inactive
	@Override
	public void updateInactive(int id) throws SQLException {

		String updateQuery = "update category_detail set status='Inactive' where category_id=?";
		String updateQuery1 = "update section_details set status='Inactive' where category_id=?";
		String updateQuery2 = "update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";
		String updateQuery3 = "update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";

		Connection con = null;
		PreparedStatement pstmtt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmtt = con.prepareStatement(updateQuery);
			pstmtt.setInt(1, id);
			pstmtt.executeUpdate();

			pstmt1 = con.prepareStatement(updateQuery1);
			pstmt1.setInt(1, id);
			pstmt1.executeUpdate();

			pstmt2 = con.prepareStatement(updateQuery2);
			pstmt2.executeUpdate();

			pstmt3 = con.prepareStatement(updateQuery3);
			pstmt3.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmtt, con);
			ConnectionUtil.closePreparedStatement(pstmt1, con);
			ConnectionUtil.closePreparedStatement(pstmt2, con);
			ConnectionUtil.closePreparedStatement(pstmt3, con);
		}

	}

	// Update Active
	@Override
	public void updateActive(int id) throws SQLException {
		// get connection
		Connection con = null;
		String updateQuery = "update category_detail set status='active' where category_id=?";
		String updateQuery1 = "update section_details set status='active' where category_id=?";
		String updateQuery2 = "update question_details set status=(select status from section_details where question_details.section_id=section_details.section_id)";
		String updateQuery3 = "update  answer set status=(select status from question_details where answer.question_id=question_details.question_id)";
		PreparedStatement pstmtmt= null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmtmt = con.prepareStatement(updateQuery);
			pstmtmt.setInt(1, id);
			pstmtmt.executeUpdate();

			pstmt1 = con.prepareStatement(updateQuery1);
			pstmt1.setInt(1, id);
			pstmt1.executeUpdate();

			pstmt2 = con.prepareStatement(updateQuery2);
			pstmt2.executeUpdate();
			

			pstmt3 = con.prepareStatement(updateQuery3);
			pstmt3.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmtmt, con);
			ConnectionUtil.closePreparedStatement(pstmt1, con);
			ConnectionUtil.closePreparedStatement(pstmt2, con);
			ConnectionUtil.closePreparedStatement(pstmt3, con);
		}

	}

	// List of category
	@Override
	public List<Category> showAllCategory() throws SQLException {
		List<Category> categoryList = new ArrayList<>();

		String selectQuery = "select category_id,category_name,description from category_detail where status='active'";
		Connection con = null;
		PreparedStatement tstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			tstmt = con.prepareStatement(selectQuery);
			rs = tstmt.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setDescription(rs.getString(3));
				categoryList.add(category);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (tstmt != null) {
				tstmt.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return categoryList;
	}

	// List of category for admin

	@Override
	public List<Category> allCategory() throws SQLException {
		List<Category> categoryList = new ArrayList<>();

		String selectQuery = "select category_id,category_name,status from category_detail";

		Connection con = null;
		PreparedStatement smtmt = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.getDbConnection();
			smtmt = con.prepareStatement(selectQuery);
			rs = smtmt.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setStatus(rs.getString(3));
				categoryList.add(category);
			}

		}

		catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (smtmt != null) {
				smtmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return categoryList;
	}

	// Find Status

	@Override
	public String findStatus(int id) throws SQLException {
		String findUserId = "select status from category_detail where category_id=?";
		Connection con = null;
		PreparedStatement stsmt = null;
		ResultSet rs = null;
		String status = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stsmt = con.prepareStatement(findUserId);
			stsmt.setInt(1, id);
			rs = stsmt.executeQuery();
			if (rs.next()) {
				status = rs.getString(1);
			}
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (stsmt != null) {
				stsmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;

	}

}
