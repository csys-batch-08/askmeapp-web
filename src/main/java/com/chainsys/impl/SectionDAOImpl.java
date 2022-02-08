package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		PreparedStatement pst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			System.out.println(section.getSectionName());
			pst.setString(1, section.getSectionName());
			System.out.println(section.getCategoryId());
			pst.setInt(2, section.getCategoryId());
			System.out.println(section.getImage());
			pst.setString(3, section.getImage());
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
	public void update(Section section) throws SQLException {
		String updateQuery = "update section_details set section_name=?  where section_id=?";
		// get connection
		Connection con = null;
		System.out.println("Connection successfully");
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, section.getSectionName());
			pstmt.setInt(2, section.getSectionId());
			int i = pstmt.executeUpdate();
			System.out.println("Updated successfully" + i);

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

	// Find section

	@Override
	public int findSectionId(String sectionName) throws SQLException {
		String findUserId = "select section_id from section_details where section_name='" + sectionName + "'";
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
	// Search by category name

	@Override
	public List<Section> showSectionName(Category category) throws SQLException {

		List<Section> sectionList = new ArrayList<Section>();

		String selectQuery = "select section_id,section_name from section_details where category_id=? and status='active'";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, category.getCategoryId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Section section = new Section();
				section.setSectionId(rs.getInt(1));
				section.setSectionName(rs.getString(2));
				sectionList.add(section);
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

		return sectionList;
	}

	// show all

	@Override
	public List<Section> showAllSection() throws SQLException {

		List<Section> sectionList = new ArrayList<Section>();

		String selectQuery = "select section_id,section_name,status from section_details";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Section section = new Section();
				section.setSectionId(rs.getInt(1));
				section.setSectionName(rs.getString(2));
				section.setStatus(rs.getString(3));
				sectionList.add(section);
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

		return sectionList;
	}

}
