package org.example.userservice.service;

import org.example.userservice.models.Role;
import org.example.userservice.models.User;
import org.example.userservice.models.UserRegistrationDTO;
import org.example.userservice.models.UserUpdateDTO;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

        User existingUser = userOptional.get();

        existingUser.setFirstname(user.firstname());
        existingUser.setLastname(user.lastname());
        existingUser.setEmail(user.email());
        existingUser.setAge(user.age());
        existingUser.setPhone(user.phone());
        existingUser.setAddress(user.address());
        existingUser.setPassword(user.password());

        User updatedUser = userRepository.save(existingUser);

        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<User> deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(userId);
        return ResponseEntity.ok(userOptional.get());
    }

    public ResponseEntity<User> updateUserPassword(Long userId, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        User existingUser = optionalUser.get();
        existingUser.setPassword(newPassword);

        userRepository.save(existingUser);

        return ResponseEntity.accepted().body(existingUser);
    }
}