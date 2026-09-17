package com.fashionstore.dao;

import com.fashionstore.model.OrderItem;
import java.util.List;

public interface OrderItemDao {
    boolean addOrderItems(List<OrderItem> items);
    List<OrderItem> getItemsByOrderId(int orderId);
}