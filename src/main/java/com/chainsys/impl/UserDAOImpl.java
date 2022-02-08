package com.chainsys.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		PreparedStatement pst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmailId());
			pst.setString(3, user.getPassword());
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

	// Update user-password
	@Override
	public void update(String password, String email) throws SQLException {
		String updateQuery = "update user_detail set password=? where email=?";
		// get connection
		Connection con = null;

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
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

	// Login-Validate User

	@Override
	public User validateUser1(String email, String password) throws SQLException {
		String validateQuery = "select email,password from user_detail where role='USER'and email='" + email
				+ "' and password='" + password + "'";
		Connection con = null;
		Statement stmt = null;
		User user = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(validateQuery);
			// validate user input
			if (rs.next()) {
				user = new User(0, null, email, password, null);
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
		return user;
	}

	// Find User
	@Override
	public int findUserId(String email) throws SQLException {
		String findUserId = "select user_id from user_detail where email='" + email + "'";
		Connection con = null;
		PreparedStatement stmt = null;
		int userId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findUserId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				userId = rs.getInt(1);
				System.out.println(userId);
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
		return userId;

	}

	// List of User
	@Override
	public List<User> showAllUser() throws SQLException {

		List<User> userList = new ArrayList<User>();

		String selectQuery = "select user_id,user_name,email,subscriber from user_detail where role='USER'";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmailId(rs.getString(3));
				user.setSubscriber(rs.getString(4));
				userList.add(user);
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

		return userList;
	}

	// Subscriber update

	@Override
	public void updateSubscribe(User user) throws SQLException {
		String updateQuery = "update user_detail set subscriber='yes' where role='USER' and email=?";
		// get connection
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, user.getEmailId());
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

	// List of Subscriber
	@Override
	public List<User> subscribeUser() throws SQLException {
		List<User> userList = new ArrayList<User>();

		String selectQuery = "select user_name,email from user_detail where role='USER' and subscriber='yes'";

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(selectQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString(1));
				user.setEmailId(rs.getString(2));
				userList.add(user);
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

		return userList;
	}

	@Override
	public boolean insertSection(SubscribeUser user) throws SQLException {
		// Query-insert User
		String insertQuery = "insert into subscribe_user(user_id,section_name) values(?,?)";
		// DB connection

		Connection con = null;
		PreparedStatement pst = null;
		// Get all values
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getSectionName());
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

		return true;

	}

	// Find User Subscriber
	@Override
	public String findSubscriber(int id) throws SQLException {
		String findSubscriber = "select subscriber from user_detail where user_id='" + id + "'";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String subscriber = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findSubscriber);
			rs = stmt.executeQuery();
			if (rs.next()) {
				subscriber = rs.getString(1);
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

		return subscriber;

	}

	// Exception
	@Override
	public List<User> emailExists(User user) throws SQLException {
		List<User> userList = new ArrayList<User>();
		String selectQuery = "select user_name,password from user_detail where role='USER' and email=? ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(selectQuery);
			stmt.setString(1, user.getEmailId());
			rs = stmt.executeQuery();
			while (rs.next()) {

				user.setName(rs.getString(1));
				user.setPassword(rs.getString(2));
				userList.add(user);
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

		return userList;
	}

}
