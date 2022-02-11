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

import com.chainsys.dao.AskmeDAOInterface;
import com.chainsys.model.AskMe;
import com.chainsys.util.ConnectionUtil;

public class AskmeDAOImpl implements AskmeDAOInterface {
	// insert
	@Override
	public void askmequestions(AskMe askMe) throws SQLException {
		String insertQuery = "insert into ask_me_questions(user_id,category_id,section_id,question_id) values(?,?,?,?)";
		// DB connection
		Connection con = null;
		PreparedStatement pst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, askMe.getUserId());
			pst.setInt(2, askMe.getCategoryId());
			pst.setInt(3, askMe.getSectionId());
			pst.setInt(4, askMe.getQuestionId());
			pst.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

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

	@Override
	public List<AskMe> FindUserId(AskMe askMe) throws SQLException {
		List<AskMe> askList = new ArrayList<>();
		String selectQuery = "select ask_me_questions.question_id from (user_detail inner join ask_me_questions using(user_id))where user_id=? and question_id=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(selectQuery);
			pst.setInt(1, askMe.getUserId());
			pst.setInt(2, askMe.getQuestionId());
			rs = pst.executeQuery();
			while (rs.next()) {
				AskMe ask = new AskMe();
				ask.setQuestionId(rs.getInt(3));
				askList.add(askMe);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return askList;
	}

}
