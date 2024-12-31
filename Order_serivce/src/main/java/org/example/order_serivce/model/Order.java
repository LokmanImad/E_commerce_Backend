package org.example.order_serivce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
enum State{DELIVERED , PENDING , CANCELLED , PROCESSING  }
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO userId
    private LocalDate date;
    // TODO IDproduit
    private State state ;
    private BigDecimal total;



}
