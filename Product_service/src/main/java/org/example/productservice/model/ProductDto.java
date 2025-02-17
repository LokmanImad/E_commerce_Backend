package org.example.productservice.model;

public record ProductDto(
        String name,
        String description,
        double price,
        int stock,
        String categorises,
        String imagePath,
        double promo) {
}
