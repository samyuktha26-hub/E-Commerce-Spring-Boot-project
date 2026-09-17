package com.fashionstore.controller;

import com.fashionstore.dao.UserDao;
import com.fashionstore.dao.UserDaoImpl;
import com.fashionstore.model.User;

// 🚨 STRICTLY JAKARTA IMPORTS 🚨
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserDao userDao = new UserDaoImpl();

    // Show the login page when the user visits /login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    // Process the form data when the user clicks "Login"
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get the data typed into the HTML form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // 2. Ask the DAO to check the database
        User user = userDao.loginUser(email, password);
        
        if (user != null) {
            // SUCCESS: Create a secure session and store the user
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            
            // Send them to the home page
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // FAIL: Send them back to the login page with an error message
            request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}