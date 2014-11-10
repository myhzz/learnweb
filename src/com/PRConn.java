package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PRConn {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/problem?user=root&password=123";
	private static Connection conn;

	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return conn;
	}
}
	