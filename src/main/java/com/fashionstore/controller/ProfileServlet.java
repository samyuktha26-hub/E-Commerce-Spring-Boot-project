package com.fashionstore.controller;

import com.fashionstore.dao.OrderDao;
import com.fashionstore.dao.OrderDaoImpl;
import com.fashionstore.model.User; // Make sure this matches your User model import!

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Using the DAO you already have!
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // 1. Security Check: Grab the logged-in user from the session.
        // (Note: Change "currentUser" if you named it something else in your LoginServlet)
        User currentUser = (User) session.getAttribute("loggedInUser");
        
        if (currentUser == null) {
            // Boot them back to the login page if they try to guess the URL
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        
        try {
            // 2. Fetch their specific order history
            // (Note: Adjust the method name to match exactly what is in your OrderDao)
            List<?> orderHistory = orderDao.getOrdersByUserId(currentUser.getUserId());
            request.setAttribute("orders", orderHistory);
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Could not load your order history at this time.");
        }

        // 3. Send them to the dashboard
        request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
    }
}