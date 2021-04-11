package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDao {
	public static Connection getConnection() throws ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/db_28";
        // Database name to access
        String dbUsername = "root";
        String dbPassword = "123456";
  
        Class.forName(dbDriver);

        Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}