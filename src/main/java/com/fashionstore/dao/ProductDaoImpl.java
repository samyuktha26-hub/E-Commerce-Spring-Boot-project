package com.fashionstore.dao;

import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    // 1. THE HELPER METHOD: This prevents errors by extracting data the exact same way every time!
    private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        
        // Ensure you have this line so it actually grabs the new category!
        product.setCategory(rs.getString("category")); 
        product.setImageUrl(rs.getString("image_url"));
        product.setPrice(rs.getDouble("price"));
        // If you have price/description, uncomment these:
        // product.setPrice(rs.getDouble("price"));
        // product.setDescription(rs.getString("description"));
        
        return product;
    }

    // 2. GET ALL PRODUCTS (For the main shop page)
    @Override
    public List<Product> getAllActiveProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE is_active = TRUE";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                products.add(extractProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // 3. GET SINGLE PRODUCT (For the Product Details page)
    @Override
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM PRODUCTS WHERE product_id = ? AND is_active = TRUE";
        Product product = null;
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, productId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = extractProductFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    // 4. THE NEW FILTER METHOD (For the Men/Women/Kids buttons)
    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category = ? AND is_active = TRUE";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, category);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(extractProductFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
