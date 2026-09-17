package com.fashionstore.dao;

import com.fashionstore.model.User;

public interface UserDao {
    // Inserts a new user into the database
    boolean registerUser(User user);
    
    // Checks credentials and returns the User object if successful
    User loginUser(String email, String password);
    
    // Fetches a user's details for their profile page
    User getUserById(int userId);
    
    // Updates profile information (phone, address, etc.)
    boolean updateUserProfile(User user);
}
