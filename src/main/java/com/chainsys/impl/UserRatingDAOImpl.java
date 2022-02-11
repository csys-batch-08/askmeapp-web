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
		PreparedStatement psttmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			psttmt = con.prepareStatement(updateQuery);
			psttmt.setInt(1, userRating.getRating());
			psttmt.setInt(2, userRating.getRateCount());
			psttmt.setString(3, userRating.getSectionName());
			psttmt.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (psttmt != null) {
				psttmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// priority by rating

	@Override
	public List<UserRating> showRating() throws SQLException {

		List<UserRating> userRatingList = new ArrayList<>();

		String selectQuery = "select section_name,(rating/rating_count) as average from section_details  where status='active' order by average DESC";

		Connection con = null;
		PreparedStatement psstmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			psstmt = con.prepareStatement(selectQuery);
			ResultSet rs = psstmt.executeQuery();
			while (rs.next()) {
				UserRating ratingList = new UserRating();
				ratingList.setSectionName(rs.getString(1));
				int ratingavg = rs.getInt(2);
				ratingList.setRating(ratingavg);

				userRatingList.add(ratingList);
			}

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

		return userRatingList;
	}

	// User Place Rating
	@Override
	public List<UserRating> findRating(Section section) throws SQLException {

		List<UserRating> rateList = new ArrayList<>();
		String findRating = "select rating,rating_count from section_details where section_name=?";
		Connection con = null;
		PreparedStatement ppstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			ppstmt = con.prepareStatement(findRating);
			ppstmt.setString(1, section.getSectionName());
			rs = ppstmt.executeQuery();
			while (rs.next()) {
				UserRating rate = new UserRating();
				rate.setRating(rs.getInt(1));
				rate.setRateCount(rs.getInt(2));
				rateList.add(rate);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {

			if (ppstmt != null) {
				ppstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return rateList;
	}

}
