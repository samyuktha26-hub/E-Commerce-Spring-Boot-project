package com.fashionstore.dao;

import com.fashionstore.model.CartItem;
import com.fashionstore.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItemDaoImpl implements CartItemDao {

    @Override
    public List<CartItem> getItemsByCartId(int cartId) {
        List<CartItem> items = new ArrayList<>();
        String sql = "SELECT * FROM CART_ITEMS WHERE cart_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cartId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new CartItem(rs.getInt("cart_item_id"), rs.getInt("cart_id"), rs.getInt("product_id"), rs.getString("size_label"), rs.getInt("quantity"), rs.getDouble("unit_price"), rs.getTimestamp("added_at")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public boolean addItemToCart(CartItem item) {
        String sql = "INSERT INTO CART_ITEMS (cart_id, product_id, size_label, quantity, unit_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, item.getCartId());
            pstmt.setInt(2, item.getProductId());
            pstmt.setString(3, item.getSizeLabel());
            pstmt.setInt(4, item.getQuantity());
            pstmt.setDouble(5, item.getUnitPrice());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateItemQuantity(int cartItemId, int newQuantity) {
        String sql = "UPDATE CART_ITEMS SET quantity = ? WHERE cart_item_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, cartItemId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeItemFromCart(int cartItemId) {
        String sql = "DELETE FROM CART_ITEMS WHERE cart_item_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cartItemId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clearCartItems(int cartId) {
        String sql = "DELETE FROM CART_ITEMS WHERE cart_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cartId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}