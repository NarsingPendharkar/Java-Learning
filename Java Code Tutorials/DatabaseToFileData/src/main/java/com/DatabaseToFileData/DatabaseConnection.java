package com.DatabaseToFileData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

public class DatabaseConnection {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/hibernatetest";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public Connection connection() {
    try {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Connected to database...");
        
        return conn;
    } catch (SQLException e) {
        System.out.println("Error connecting to database: " + e.getMessage());
        return null;
    }
}
}
