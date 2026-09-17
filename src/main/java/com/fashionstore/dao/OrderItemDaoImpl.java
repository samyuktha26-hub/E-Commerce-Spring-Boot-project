package com.fashionstore.dao;

import com.fashionstore.model.OrderItem;
import com.fashionstore.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

    @Override
    public boolean addOrderItems(List<OrderItem> items) {
        String sql = "INSERT INTO ORDER_ITEMS (order_id, product_id, product_name, quantity, unit_price, subtotal, size_label) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Using batch processing for efficiency
            for (OrderItem item : items) {
                pstmt.setInt(1, item.getOrderId());
                pstmt.setInt(2, item.getProductId());
                pstmt.setString(3, item.getProductName());
                pstmt.setInt(4, item.getQuantity());
                pstmt.setDouble(5, item.getUnitPrice());
                pstmt.setDouble(6, item.getSubtotal());
                pstmt.setString(7, item.getSizeLabel());
                pstmt.addBatch();
            }
            
            int[] results = pstmt.executeBatch();
            return results.length == items.size();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<OrderItem> getItemsByOrderId(int orderId) {
        List<OrderItem> items = new ArrayList<>();
        String sql = "SELECT * FROM ORDER_ITEMS WHERE order_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new OrderItem(rs.getInt("order_item_id"), rs.getInt("order_id"), rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("quantity"), rs.getDouble("unit_price"), rs.getDouble("subtotal"), rs.getString("size_label")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
