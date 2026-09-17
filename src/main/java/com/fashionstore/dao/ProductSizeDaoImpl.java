package com.fashionstore.dao;

import com.fashionstore.model.ProductSize;
import com.fashionstore.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSizeDaoImpl implements ProductSizeDao {

    @Override
    public List<ProductSize> getSizesForProduct(int productId) {
        List<ProductSize> sizes = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT_SIZES WHERE product_id = ? AND is_available = TRUE";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    sizes.add(new ProductSize(rs.getInt("product_size_id"), rs.getInt("product_id"), rs.getString("size_label"), rs.getInt("stock_quantity"), rs.getString("sku_code"), rs.getBoolean("is_available")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizes;
    }

    @Override
    public boolean updateStockQuantity(int productSizeId, int newQuantity) {
        String sql = "UPDATE PRODUCT_SIZES SET stock_quantity = ? WHERE product_size_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, productSizeId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ProductSize getProductSizeById(int productSizeId) {
        String sql = "SELECT * FROM PRODUCT_SIZES WHERE product_size_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productSizeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductSize(rs.getInt("product_size_id"), rs.getInt("product_id"), rs.getString("size_label"), rs.getInt("stock_quantity"), rs.getString("sku_code"), rs.getBoolean("is_available"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}