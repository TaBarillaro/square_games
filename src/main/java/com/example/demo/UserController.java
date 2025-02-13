package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserCreationParams params) {
        return null;
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return null;
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable String userId) {
        return null;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId) {

    }

}
