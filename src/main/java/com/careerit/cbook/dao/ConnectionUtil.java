package com.careerit.cbook.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public enum ConnectionUtil {
	db;

	private static Properties properties = new Properties();
	static {
		try {
			properties.load(ConnectionUtil.class.getResourceAsStream("/application.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(properties.getProperty("db.url"), properties);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}
	public void close(Statement st, Connection con) {
		try {
			
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}
}
