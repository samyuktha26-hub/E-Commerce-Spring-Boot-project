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

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Check if the user clicked a category filter in the URL
        String category = request.getParameter("category");
        java.util.List<Product> products;

        if (category != null && !category.isEmpty()) {
            // If they clicked "Men", "Women", or "Kids"
            products = productDao.getProductsByCategory(category);
            request.setAttribute("currentCategory", category);
        } else {
            // If they just clicked "Shop All"
            products = productDao.getAllActiveProducts();
            request.setAttribute("currentCategory", "All Collections");
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
    }
}