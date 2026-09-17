package com.fashionstore.dao;

import com.fashionstore.model.CartItem;
import java.util.List;

public interface CartItemDao {
    List<CartItem> getItemsByCartId(int cartId);
    boolean addItemToCart(CartItem item);
    boolean updateItemQuantity(int cartItemId, int newQuantity);
    boolean removeItemFromCart(int cartItemId);
    boolean clearCartItems(int cartId);
}