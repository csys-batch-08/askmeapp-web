package com.chainsys.util;

import java.beans.Statement;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ConnectionUtil {
	
	public static Connection getDbConnection() throws ClassNotFoundException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, SQLException  {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",ConnectionPassword.decrypt());
		
	}

	private ConnectionUtil() {
		super();
	}
	public void closeConnection(ResultSet rs, PreparedStatement pstmt,Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
	public static void closePreparedStatement(PreparedStatement pstmt,Connection con) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void closeStatement(Statement stmt,Connection con) {
		try {
			if (stmt != null) {
				((Connection) stmt).close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
