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
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Instantiate your Product DAO
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // 1. Fetch all products from the database
            // (Assuming your DAO has a method named getAllProducts or similar)
            List<Product> productList = productDao.getAllActiveProducts(); 
            
            // 2. Attach the list to the request so the JSP can see it
            request.setAttribute("products", productList);
            
            // 3. Send it to the view
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Could not load products at this time.");
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }
    }
}