package org.example.order_serivce.controller;

import org.example.order_serivce.model.Order;
import org.example.order_serivce.model.OrderDTO;
import org.example.order_serivce.model.OrderStateUpdateDTO;
import org.example.order_serivce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId){
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderId, orderDTO);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> deleteUser(@PathVariable("orderId") Long orderId){
        return orderService.deleteUser(orderId);
    }

    @PatchMapping("{orderId}")
    public ResponseEntity<Order> updateOrderState(@PathVariable("orderId") Long orderId, OrderStateUpdateDTO dto){
        return orderService.updateOrderState(orderId, dto);
    }
}