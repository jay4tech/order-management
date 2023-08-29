package com.tcs.ordermanagement.controller;

import com.tcs.ordermanagement.entity.Order;
import com.tcs.ordermanagement.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

//    POST /orders - Place a new order.
//            PUT /orders/{orderId} - Update order status.
//            GET /orders/{orderId} - View order details.
//            GET /users/{userId}/orders - List orders for a user.

    /**
     * Place a new order.
     * @param order
     * @return
     */
    @PostMapping("/")
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    /**
     *  Update order status.
     * @param orderId
     * @return
     */
    @PutMapping("/{orderId}")
    public Order updateOrder(@RequestBody Long orderId){
        return orderService.updateOrder(orderId);
    }

    /**
     * View order details.
     * @param orderId
     * @return
     */
    @GetMapping("/{orderId}")
    public Order getOrder(@RequestBody Long orderId){
        return orderService.getOrder(orderId);
    }

    /**
     * List orders for a user.
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public List<Order> getUserOrders(@RequestBody Long userId){
        return orderService.getUserOrders(userId);
    }
}
