package org.example.userservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String firstname;
    private String lastname;
    private Role role ;
    @Email
    private String email;
    private int age;
    private String password;
    private String address;
    private String phone;
}
