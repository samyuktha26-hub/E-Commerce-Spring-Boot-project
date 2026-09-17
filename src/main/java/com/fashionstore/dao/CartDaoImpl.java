package com.fashionstore.dao;

import com.fashionstore.model.Cart;
import com.fashionstore.util.DBConnection;
import java.sql.*;

public class CartDaoImpl implements CartDao {

    @Override
    public Cart getCartByUserId(int userId) {
        String sql = "SELECT * FROM CART WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cart(rs.getInt("cart_id"), rs.getInt("user_id"), rs.getTimestamp("created_at"), rs.getTimestamp("updated_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createCart(int userId) {
        String sql = "INSERT INTO CART (user_id) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCart(int cartId) {
        String sql = "DELETE FROM CART WHERE cart_id = ?";
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