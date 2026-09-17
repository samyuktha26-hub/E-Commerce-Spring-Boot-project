package com.fashionstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Update these to match your local MySQL setup
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fashion_store";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "root"; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 1. Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection successful!");
            
        } catch (ClassNotFoundException e) {
        	throw new RuntimeException("CRITICAL ERROR: Tomcat cannot find the MySQL Driver!", e);
        } catch (SQLException e) {
        	throw new RuntimeException("CRITICAL ERROR: Database connection failed! Check URL/Username/Password.", e);
        }
        return connection;
    }
}