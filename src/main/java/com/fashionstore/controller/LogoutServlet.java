package com.fashionstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Grab the current session, but don't create a new one if it doesn't exist (false)
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // This destroys the session entirely. 
            // It logs the user out AND empties their session-based shopping cart!
            session.invalidate(); 
        }
        
        // Redirect them safely back to the login page
        response.sendRedirect(request.getContextPath() + "/login");
    }
}