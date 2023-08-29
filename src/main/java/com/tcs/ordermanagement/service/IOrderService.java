package com.tcs.ordermanagement.service;

import com.tcs.ordermanagement.entity.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Order order);

    Order updateOrder(Long orderId);

    Order getOrder(Long orderId);

    List<Order> getUserOrders(Long userId);
}
