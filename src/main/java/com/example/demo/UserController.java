package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserEntityRepository userEntityRepository;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity params) {

        UserEntity userEntity = new UserEntity(params.email, params.password);
        return this.userEntityRepository.save(userEntity);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable UUID userId) {

        return new UserDto(userId, userService.getUserById(userId).email);
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable String userId, @RequestBody UserCreationParams params) {
        return null;
    }

    @DeleteMapping("/users/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return true;
    }

}
