package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.dao.UserRatingDAOInterface;
import com.chainsys.model.Section;
import com.chainsys.model.UserRating;
import com.chainsys.util.ConnectionUtil;

public class UserRatingDAOImpl implements UserRatingDAOInterface {
	// rating update

	@Override
	public void updateRating(UserRating userRating) throws SQLException {
		String updateQuery = "update section_details set rating=?,rating_count=? where section_name=?";
		// get connection
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, userRating.getRating());
			pstmt.setInt(2, userRating.getRateCount());
			pstmt.setString(3, userRating.getSectionName());
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

	// priority by rating

	@Override
	public List<UserRating> showRating() throws SQLException {

		List<UserRating> userRatingList = new ArrayList<UserRating>();

		String selectQuery = "select section_name,(rating/rating_count) as average from section_details  where status='active' order by average DESC";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserRating ratingList = new UserRating();
				ratingList.setSectionName(rs.getString(1));
				int ratingavg = rs.getInt(2);
				ratingList.setRating(ratingavg);

				userRatingList.add(ratingList);
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

		return userRatingList;
	}

	// User Place Rating
	@Override
	public List<UserRating> findRating(Section section) throws SQLException {

		List<UserRating> rateList = new ArrayList<UserRating>();
		String findRating = "select rating,rating_count from section_details where section_name=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(findRating);
			pstmt.setString(1, section.getSectionName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserRating rate = new UserRating();
				rate.setRating(rs.getInt(1));
				rate.setRateCount(rs.getInt(2));
				rateList.add(rate);
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

		return rateList;
	}

}
