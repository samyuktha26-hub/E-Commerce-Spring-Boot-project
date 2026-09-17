package com.fashionstore.controller;

import com.fashionstore.model.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/cart/remove")
public class RemoveFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        if (cart != null) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            String sizeLabel = request.getParameter("sizeLabel");
            
            // Loop through the cart and remove the exact item matching the ID and Size
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProductId() == productId && item.getSizeLabel().equals(sizeLabel)) {
                    iterator.remove();
                    break; // Stop after removing the one item
                }
            }
            
            // Update session
            session.setAttribute("cart", cart);
        }
        
        // Send them right back to the cart page
        response.sendRedirect(request.getContextPath() + "/cart");
    }
}