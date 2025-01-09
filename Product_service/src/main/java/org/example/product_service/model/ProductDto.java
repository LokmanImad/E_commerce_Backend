package org.example.product_service.model;

public record ProductDto(
        String name,
        String description,
        double price,
        int stock,
        String categorises,
        String imagePath,
        double promo) {
}
