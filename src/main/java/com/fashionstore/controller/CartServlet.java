package com.fashionstore.controller;

import com.fashionstore.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart", "/cart/add"})
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Grab data from home.jsp
        int productId = Integer.parseInt(request.getParameter("productId"));
        String sizeLabel = request.getParameter("sizeLabel");
        String productName = request.getParameter("productName");
        String imageUrl = request.getParameter("imageUrl");
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Check if item (with the SAME size) is already in the cart
        boolean itemExists = false;
        for (CartItem item : cart) {
            if (item.getProductId() == productId && item.getSizeLabel().equals(sizeLabel)) {
                item.setQuantity(item.getQuantity() + 1);
                itemExists = true;
                break;
            }
        }

        // If it's a new item or a different size, create your specific CartItem
        if (!itemExists) {
            CartItem newItem = new CartItem();
            newItem.setProductId(productId);
            newItem.setProductName(productName);
            newItem.setSizeLabel(sizeLabel);
            newItem.setQuantity(1);
            newItem.setUnitPrice(0.0); // Safety fallback since price was removed from Product
            newItem.setAddedAt(new Timestamp(System.currentTimeMillis())); // Generates current SQL timestamp
            newItem.setImageUrl(imageUrl);
            // Note: cartId and cartItemId remain default (0) because we are using Session storage right now, not saving to a DB table yet.
            cart.add(newItem);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath() + "/cart");
    }
}