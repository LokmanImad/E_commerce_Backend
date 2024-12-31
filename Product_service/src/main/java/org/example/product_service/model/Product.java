package org.example.product_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;


@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
    private BigDecimal price;
    private int stock;
    private String categories;
    private String image;
    private double promo;




}
