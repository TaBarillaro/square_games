package com.example.demo.controller;

import com.example.demo.dao.UserEntityRepository;
import com.example.demo.dto.UserCreationParams;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserEntityRepository userEntityRepository;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity params) {

        UserEntity userEntity = new UserEntity(params.getEmail(), params.getPassword());
        return this.userEntityRepository.save(userEntity);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) throws CredentialNotFoundException {
        try {
            UUID uuid = UUID.fromString(userId);
            return userService.getUserById(uuid.toString());
        } catch (IllegalArgumentException e) {
            throw new CredentialNotFoundException("Invalid UUID String" + userId);
        }
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable UUID userId, @RequestBody UserCreationParams params) {
        return null;
    }

    @DeleteMapping("/users/{userId}")
    public boolean deleteUser(@PathVariable UUID userId) {
        return true;
    }


}
