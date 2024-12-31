package org.example.userservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity @AllArgsConstructor @Getter @Setter @NoArgsConstructor @Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastnane;
    private int age;
    private String role ;
    private String password;
    private String adresse;
    private String phone;




}
