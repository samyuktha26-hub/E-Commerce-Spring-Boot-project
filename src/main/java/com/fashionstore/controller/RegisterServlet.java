package com.fashionstore.controller;

import com.fashionstore.dao.UserDao;
import com.fashionstore.dao.UserDaoImpl;
import com.fashionstore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserDao userDao = new UserDaoImpl();

    // Show the registration page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    // Process the new user data
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Grab the original fields
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Grab the NEW fields
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String deliveryAddress = request.getParameter("deliveryAddress");

        // Create the user object
        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        
        // Set the NEW fields
        newUser.setPhone(phone);
        newUser.setGender(gender);
        newUser.setAddress(deliveryAddress);

        // Send to DAO (You will also need to update your UserDaoImpl's INSERT statement to include these 3 new columns!)
        boolean isRegistered = userDao.registerUser(newUser);

        if (isRegistered) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Email might already exist.");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }
    }
}