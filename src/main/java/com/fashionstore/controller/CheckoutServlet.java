package com.fashionstore.controller;

import com.fashionstore.dao.OrderDao;
import com.fashionstore.dao.OrderDaoImpl;
import com.fashionstore.dao.OrderItemDao;
import com.fashionstore.dao.OrderItemDaoImpl;
import com.fashionstore.model.CartItem;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loggedInUser");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }

        double totalAmount = 0.0;
        for (CartItem item : cart) {
            totalAmount += (item.getUnitPrice() * item.getQuantity());
        }
        request.setAttribute("checkoutTotal", totalAmount);

        request.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("loggedInUser");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        if (currentUser == null || cart == null || cart.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }

        double totalAmount = 0.0;
        for (CartItem item : cart) {
            totalAmount += (item.getUnitPrice() * item.getQuantity());
        }

        Order newOrder = new Order(
            currentUser.getUserId(),
            totalAmount,
            "Cash on Delivery", 
            "Processing", 
            currentUser.getAddress()
        );

        try {
            int generatedOrderId = orderDao.createOrder(newOrder);
            
            if (generatedOrderId > 0) {
                
                // 1. Create a list to hold the database items
                List<OrderItem> orderItemsList = new ArrayList<>();
                
                // 2. Convert CartItems to OrderItems and add to list
                for (CartItem item : cart) {
                    double subtotal = item.getUnitPrice() * item.getQuantity();
                    
                    OrderItem orderItem = new OrderItem(
                        generatedOrderId, 
                        item.getProductId(), 
                        item.getProductName(), 
                        item.getQuantity(), 
                        item.getUnitPrice(), 
                        subtotal, 
                        item.getSizeLabel()
                    );
                    orderItemsList.add(orderItem);
                }

                // 3. Send the entire list to your BATCH DAO method!
                boolean itemsSaved = orderItemDao.addOrderItems(orderItemsList);

                if (itemsSaved) {
                    session.removeAttribute("cart");
                    request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Failed to save order items.");
                    request.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(request, response);
                }
                
            } else {
                request.setAttribute("errorMessage", "Failed to process your order in the database.");
                request.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "A system error occurred during checkout.");
            request.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(request, response);
        }
    }
}