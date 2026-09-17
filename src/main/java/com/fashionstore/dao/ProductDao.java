package com.fashionstore.dao;

import com.fashionstore.model.Product;
import java.util.List;

public interface ProductDao {
    // Gets all active products for the homepage
    List<Product> getAllActiveProducts();
    
    // Gets products filtered by category (e.g., just Men's wear)
    List<Product> getProductsByCategory(String category);
    
    // Gets details for a single product page
    Product getProductById(int productId);
}