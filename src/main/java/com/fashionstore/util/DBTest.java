package com.fashionstore.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {

    public static void main(String[] args) {
        System.out.println("Attempting to connect to the Fashion Store database...");

        // Try to get the connection from your utility class
        try (Connection conn = DBConnection.getConnection()) {
            
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ SUCCESS! Your Java application is connected to MySQL.");
                System.out.println("Database Product Name: " + conn.getMetaData().getDatabaseProductName());
            } else {
                System.out.println("❌ FAILED! The connection object is null or closed.");
            }
            
        } catch (SQLException e) {
            System.out.println("❌ FAILED! An SQL exception occurred.");
            e.printStackTrace();
        }
    }
}
