package org.example.order_service.model;

public record OrderDTO(Long productId, Long userId, double total) {
}
