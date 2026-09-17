package com.fashionstore.controller;

import com.fashionstore.dao.ProductDao;
import com.fashionstore.dao.ProductDaoImpl;
import com.fashionstore.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Get the ID from the URL (e.g., /product-details?id=3)
            int productId = Integer.parseInt(request.getParameter("id"));
            
            // Fetch the specific product using your awesome DAO method!
            Product product = productDao.getProductById(productId);
            
            if (product != null) {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/views/productDetails.jsp").forward(request, response);
            } else {
                // If they type a fake ID or the product is NOT active, send them back to the store
                response.sendRedirect(request.getContextPath() + "/products");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/products");
        }
    }
}