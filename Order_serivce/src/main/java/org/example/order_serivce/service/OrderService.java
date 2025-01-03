package org.example.order_serivce.service;

import org.example.order_serivce.model.Order;
import org.example.order_serivce.model.OrderDTO;
import org.example.order_serivce.model.OrderStateUpdateDTO;
import org.example.order_serivce.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<Order> getOrderById(Long orderId){
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderRepository.findAll());
    }

    public ResponseEntity<Order> addOrder(OrderDTO orderDTO){
        Order newOrder = Order.builder()
                .productId(orderDTO.productId())
                .userId(orderDTO.userId())
                .total(BigDecimal.valueOf(orderDTO.total()))
                .build();

        orderRepository.save(newOrder);
        return ResponseEntity.accepted().body(newOrder);
    }

    public ResponseEntity<Order> updateOrder(Long orderId, OrderDTO orderDTO){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Order existingUser = optionalOrder.get();
        existingUser.setUserId(orderDTO.userId());
        existingUser.setProductId(orderDTO.productId());
        existingUser.setTotal(BigDecimal.valueOf(orderDTO.total()));

        orderRepository.save(existingUser);
        return ResponseEntity.accepted().body(existingUser);
    }

    public ResponseEntity<Order> deleteUser(Long orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Order order = optionalOrder.get();
        orderRepository.deleteById(orderId);
        return ResponseEntity.ok(order);
    }

    public ResponseEntity<Order> updateOrderState(Long orderId, OrderStateUpdateDTO dto){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Order existingOrder = optionalOrder.get();
        existingOrder.setOrderState(dto.orderState());

        return ResponseEntity.accepted().body(existingOrder);
    }
}
