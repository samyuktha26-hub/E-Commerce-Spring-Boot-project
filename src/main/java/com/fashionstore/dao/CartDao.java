package com.fashionstore.dao;

import com.fashionstore.model.Cart;

public interface CartDao {
    Cart getCartByUserId(int userId);
    boolean createCart(int userId);
    boolean deleteCart(int cartId);
}