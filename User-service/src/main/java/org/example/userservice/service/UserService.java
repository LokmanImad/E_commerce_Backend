package org.example.userservice.service;

import jakarta.ws.rs.NotFoundException;
import org.apache.coyote.Response;
import org.example.userservice.models.Role;
import org.example.userservice.models.User;
import org.example.userservice.models.UserRegistrationDTO;
import org.example.userservice.models.UserUpdateDTO;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("postgres") UserRepository userRepository){
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

    public ResponseEntity<User> getUserById(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> updateUser(Long userId, UserUpdateDTO user) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();
        User oldUser = userOptional.get();

        User newUser = User.builder()
                .id(oldUser.getId())
                .firstname(user.firstname())
                .role(oldUser.getRole())
                .lastname(user.lastname())
                .email(user.email())
                .age(user.age())
                .phone(user.phone())
                .address(user.address())
                .password(user.password())
                .build();

        return ResponseEntity.ok(userRepository.save(newUser));
    }
}
