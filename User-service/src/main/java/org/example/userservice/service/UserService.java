package org.example.userservice.service;

import org.example.userservice.models.Role;
import org.example.userservice.models.User;
import org.example.userservice.models.UserRegistrationDTO;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> addUser(UserRegistrationDTO user) {
        User newUser = userRepository.save(
                User.builder().
                        firstname(user.firstname())
                        .lastname(user.lastname())
                        .email(user.email())
                        .role(Role.CUSTOMER)
                        .build()
        );
        return ResponseEntity.ok().body(newUser);
    }

    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
