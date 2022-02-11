package com.chainsys.impl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.chainsys.dao.AdminDAOInterface;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAOInterface {

	@Override
	public User validateAdmin(String email, String password) throws SQLException {
		String validateQuery = "select email,password from user_detail where role='ADMIN'and email=? and password=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(validateQuery);
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User(0, null, email, password, null);
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
		return user;
	}

}
