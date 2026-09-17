package com.fashionstore.controller;

import com.fashionstore.dao.OrderDao;
import com.fashionstore.dao.OrderDaoImpl;
import com.fashionstore.dao.OrderItemDao;
import com.fashionstore.dao.OrderItemDaoImpl;
import com.fashionstore.model.Order;
import com.fashionstore.model.OrderItem;
import com.fashionstore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/order-details")
public class OrderDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loggedInUser");
        
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        try {
            // Get the order ID from the URL link clicked in the profile
            int orderId = Integer.parseInt(request.getParameter("id"));
            
            Order order = orderDao.getOrderById(orderId);
            
            // Security: Ensure the order exists and belongs to this user
            if (order != null && order.getUserId() == currentUser.getUserId()) {
                
                // Use your DAO method to get the specific items
                List<OrderItem> items = orderItemDao.getItemsByOrderId(orderId);
                
                request.setAttribute("order", order);
                request.setAttribute("orderItems", items);
                request.getRequestDispatcher("/WEB-INF/views/orderDetails.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/profile");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/profile");
        }
    }
}