package org.example.order_serivce.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OrderDTO(Long productId, Long userId, double total) {
}
