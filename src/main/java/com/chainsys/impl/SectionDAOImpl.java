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

import com.chainsys.dao.SectionDAOInterface;
import com.chainsys.model.Category;
import com.chainsys.model.Section;
import com.chainsys.util.ConnectionUtil;

public class SectionDAOImpl implements SectionDAOInterface {

	@Override
	public void insertSection(Section section) throws SQLException {
		// Query-insert User
		String insertQuery = "insert into section_details(section_name,category_id,image) values(?,?,?)";
		// DB connection
		Connection con = null;
		PreparedStatement pstt = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pstt = con.prepareStatement(insertQuery);
			pstt.setString(1, section.getSectionName());
			pstt.setInt(2, section.getCategoryId());
			pstt.setString(3, section.getImage());
			pstt.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {

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
	public void update(Section section) throws SQLException {
		String updateQuery = "update section_details set section_name=?  where section_id=?";
		// get connection
		Connection con = null;
		System.out.println("Connection successfully");
		PreparedStatement pstt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstt = con.prepareStatement(updateQuery);
			pstt.setString(1, section.getSectionName());
			pstt.setInt(2, section.getSectionId());
			pstt.executeUpdate();
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {

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

	// Find section

	@Override
	public int findSectionId(String sectionName) throws SQLException {
		String findUserId = "select section_id from section_details where section_name=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int sectionId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findUserId);
			stmt.setString(1, sectionName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				sectionId = rs.getInt(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {

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
	// Search by category name

	@Override
	public List<Section> showSectionName(Category category) throws SQLException {

		List<Section> sectionList = new ArrayList<Section>();
		String selectQuery = "select section_id,section_name,description from section_details where category_id=? and status='active'";
		Connection con = null;
		PreparedStatement pstmmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmmt = con.prepareStatement(selectQuery);
			pstmmt.setInt(1, category.getCategoryId());
			rs = pstmmt.executeQuery();
			while (rs.next()) {
				Section section = new Section();
				section.setSectionId(rs.getInt(1));
				section.setSectionName(rs.getString(2));
				section.setDescription(rs.getString(3));
				sectionList.add(section);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {

			e.getMessage();
		} finally {
			if (pstmmt != null) {
				pstmmt.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return sectionList;
	}

	// show all

	@Override
	public List<Section> showAllSection() throws SQLException {

		List<Section> sectionList = new ArrayList<>();
		String selectQuery = "select section_id,section_name,status from section_details";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Section section = new Section();
				section.setSectionId(rs.getInt(1));
				section.setSectionName(rs.getString(2));
				section.setStatus(rs.getString(3));
				sectionList.add(section);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException
				| NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {

			e.getMessage();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return sectionList;
	}

}
