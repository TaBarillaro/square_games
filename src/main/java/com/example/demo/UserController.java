package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/users")
    public UserCreationParams createUser(@RequestBody  UserCreationParams params) {
        return userService.createUser(params);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable String userId, @RequestBody  UserCreationParams params) {
        return userService.updateUser(userId, params);
    }

    @DeleteMapping("/users/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return this.userService.deleteUser(userId);
    }

}
