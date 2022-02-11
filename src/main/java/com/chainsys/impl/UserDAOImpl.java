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

import com.chainsys.dao.UserDAOInterface;
import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class UserDAOImpl implements UserDAOInterface {

	// insert user
	@Override
	public void insertUser(User user) throws SQLException {
		// Query-insert User
		String insertQuery = "insert into user_detail(user_name,email,password) values(?,?,?)";
		// DB connection
		Connection con = null;
		PreparedStatement psst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			psst = con.prepareStatement(insertQuery);
			psst.setString(1, user.getUsername());
			psst.setString(2, user.getEmailid());
			psst.setString(3, user.getPassWord());
			psst.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();

		} finally {
			if (psst != null) {
				psst.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// Update user-password
	@Override
	public void update(String password, String email) throws SQLException {
		String updateQuery = "update user_detail set password=? where email=?";
		// get connection
		Connection con = null;

		PreparedStatement psmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			psmt = con.prepareStatement(updateQuery);
			psmt.setString(1, password);
			psmt.setString(2, email);
			psmt.executeUpdate();
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (psmt != null) {
				psmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// Login-Validate User

	@Override
	public User validateUser1(String email, String password) throws SQLException {
		String validateQuery = "select email,password from user_detail where role='USER'and email=? and password=?";
		Connection con = null;
		PreparedStatement sptmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			sptmt = con.prepareStatement(validateQuery);
			sptmt.setString(1, email);
			sptmt.setString(2, password);
			rs = sptmt.executeQuery();
			// validate user input
			if (rs.next()) {
				user = new User(0, null, email, password, null);
			}
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();

		} finally {
			if (sptmt != null) {
				sptmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return user;
	}

	// Find User
	@Override
	public int findUserId(String email) throws SQLException {
		String findUserId = "select user_id from user_detail where email=?";
		Connection con = null;
		PreparedStatement sttmt = null;
		ResultSet rs = null;
		int userId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			sttmt = con.prepareStatement(findUserId);
			sttmt.setString(1, email);
			rs = sttmt.executeQuery();
			if (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (sttmt != null) {
				sttmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return userId;

	}

	// List of User
	@Override
	public List<User> showAllUser() throws SQLException {

		List<User> userList = new ArrayList<>();

		String selectQuery = "select user_id,user_name,email,subscriber from user_detail where role='USER'";

		Connection con = null;
		PreparedStatement ptstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			ptstmt = con.prepareStatement(selectQuery);
			rs = ptstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUseriId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmailid(rs.getString(3));
				user.setSubScriber(rs.getString(4));
				userList.add(user);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();

		} finally {
			if (ptstmt != null) {
				ptstmt.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return userList;
	}

	// Subscriber update

	@Override
	public void updateSubscribe(User user) throws SQLException {
		String updateQuery = "update user_detail set subscriber='yes' where role='USER' and email=?";
		// get connection
		Connection con = null;
		PreparedStatement psmtmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			psmtmt = con.prepareStatement(updateQuery);
			psmtmt.setString(1, user.getEmailid());
			psmtmt.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (psmtmt != null) {
				psmtmt.close();
			}

			if (con != null) {
				con.close();
			}
		}

	}

	// List of Subscriber
	@Override
	public List<User> subscribeUser() throws SQLException {
		List<User> userList = new ArrayList<>();

		String selectQuery = "select user_name,email from user_detail where role='USER' and subscriber='yes'";

		Connection con = null;
		PreparedStatement stmtm = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmtm = con.prepareStatement(selectQuery);
			ResultSet rs = stmtm.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setEmailid(rs.getString(2));
				userList.add(user);
			}
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (stmtm != null) {
				stmtm.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return userList;
	}

	@Override
	public boolean insertSection(SubscribeUser user) throws SQLException {
		// Query-insert User
		String insertQuery = "insert into subscribe_user(user_id,section_name) values(?,?)";
		// DB connection

		Connection con = null;
		PreparedStatement psst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			psst = con.prepareStatement(insertQuery);
			psst.setInt(1, user.getUserId());
			psst.setString(2, user.getSectionName());
			psst.executeUpdate();

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();

		} finally {
			if (psst != null) {
				psst.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return true;

	}

	// Find User Subscriber
	@Override
	public String findSubscriber(int id) throws SQLException {
		String findSubscriber = "select subscriber from user_detail where user_id=?";
		Connection con = null;
		PreparedStatement smttmt = null;
		ResultSet rs = null;
		String subscriber = null;
		try {
			con = ConnectionUtil.getDbConnection();
			smttmt = con.prepareStatement(findSubscriber);
			smttmt.setInt(1, id);
			rs = smttmt.executeQuery();
			if (rs.next()) {
				subscriber = rs.getString(1);
			}

		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (smttmt != null) {
				smttmt.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return subscriber;

	}

	// Exception
	@Override
	public List<User> emailExists(User user) throws SQLException {
		List<User> userList = new ArrayList<>();
		String selectQuery = "select user_name,password from user_detail where role='USER' and email=? ";
		Connection con = null;
		PreparedStatement stmst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmst = con.prepareStatement(selectQuery);
			stmst.setString(1, user.getEmailid());
			rs = stmst.executeQuery();
			while (rs.next()) {
                user.setUsername(rs.getString(1));
                user.setPassWord(rs.getString(2));
				userList.add(user);
			}
		} catch (SQLException | InvalidKeyException | ClassNotFoundException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

			e.getMessage();
		} finally {
			if (stmst != null) {
				stmst.close();
			}

			if (con != null) {
				con.close();
			}
		}

		return userList;
	}

}
