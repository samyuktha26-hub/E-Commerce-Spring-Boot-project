package com.fashionstore.util;

import com.fashionstore.dao.UserDao;
import com.fashionstore.dao.UserDaoImpl;
import com.fashionstore.model.User;

public class UserDaoTest {

    public static void main(String[] args) {
        System.out.println("Starting UserDao Test...");
        System.out.println("--------------------------------------------------");

        // 1. Create an instance of the DAO we want to test
        UserDao userDao = new UserDaoImpl();

        // 2. Test the login method (Using the exact credentials you inserted)
        String testEmail = "john@example.com";
        String testPassword = "password123";
        
        System.out.println("Attempting to login with: " + testEmail);
        User loggedInUser = userDao.loginUser(testEmail, testPassword);

        // 3. Print the results to the Eclipse console
        if (loggedInUser != null) {
            System.out.println("✅ SUCCESS! User found in the database:");
            System.out.println("   ID: " + loggedInUser.getUserId());
            System.out.println("   Name: " + loggedInUser.getFullName());
            System.out.println("   Address: " + loggedInUser.getAddress());
        } else {
            System.out.println("❌ FAILED! Could not find user. Check credentials or DB connection.");
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("Test Complete.");
    }
}