package com.tcs.ordermanagement.service;

import com.tcs.ordermanagement.entity.Order;
import com.tcs.ordermanagement.entity.Product;
import com.tcs.ordermanagement.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{

    @Autowired
    IOrderRepository orderRepository;
    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order orderDb = null;
        if (optionalOrder.isPresent()){
            orderDb = optionalOrder.get();
            Product product = orderDb.getProduct();
            product.setName("Changed Name");
            product.setPrice(2000000L);
            orderRepository.save(orderDb);
        }
        return orderDb;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
