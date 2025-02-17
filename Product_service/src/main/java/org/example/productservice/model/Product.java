package org.example.productservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String categories;
    private String image;
    private double promo;
}
