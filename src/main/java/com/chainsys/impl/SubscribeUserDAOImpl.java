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

import com.chainsys.dao.SubscribeUserDAOInterface;
import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class SubscribeUserDAOImpl implements SubscribeUserDAOInterface {

	// List of User
	@Override
	public List<SubscribeUser> showAllSection(User user) throws SQLException {

		List<SubscribeUser> subscribeUserList = new ArrayList<SubscribeUser>();

		String selectQuery = "select distinct section_name from (subscribe_user inner join user_detail  using(user_id)) where user_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, user.getUserId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SubscribeUser subscribeUser = new SubscribeUser();
				subscribeUser.setSectionName(rs.getString(1));
				subscribeUserList.add(subscribeUser);
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

		return subscribeUserList;
	}

}
