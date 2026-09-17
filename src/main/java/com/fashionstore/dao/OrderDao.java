package com.fashionstore.dao;

import com.fashionstore.model.Order;
import java.util.List;

public interface OrderDao {
    // Returns the generated Order ID so we can attach OrderItems to it
    int createOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
    Order getOrderById(int orderId);
}
