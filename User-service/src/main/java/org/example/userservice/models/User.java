package org.example.userservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private Role role;
    private String email;
    private int age;
    private String password;
    private String address;
    private String phone;
}
