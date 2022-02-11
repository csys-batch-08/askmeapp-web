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
		String validate = "select email,password from user_detail where role='ADMIN'and email=? and password=?";
		Connection con = null;
		PreparedStatement stmte = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmte = con.prepareStatement(validate);
			stmte.setString(1, email);
			stmte.setString(2, password);
			rs = stmte.executeQuery();
			if (rs.next()) {
				user = new User(0, null, email, password, null);
			}
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();

		} finally {
			if (stmte != null) {
				stmte.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return user;
	}

}
