package org.example.userservice.controller;

import jakarta.validation.Valid;
import org.example.userservice.models.UserUpdateDTO;
import org.example.userservice.service.UserService;
import org.example.userservice.models.User;
import org.example.userservice.models.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

   @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRegistrationDTO user){
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){
       return userService.getUserById(userId);
    }

    @PutMapping("{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody UserUpdateDTO user){
       return userService.updateUser(userId, user);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
       return userService.deleteUser(userId);

    }
    // TODO: add patch mapping for partial updates
}
