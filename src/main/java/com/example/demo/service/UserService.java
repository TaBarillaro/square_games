package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.dto.UserCreationParams;
import com.example.demo.dto.UserDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    @NotNull
    UserDto createUser(@Validated @NotNull UserCreationParams params);
    UserDto getUserById(String userId);
    User updateUser(User user);
    User deleteUser(String userId);

    Stream<User> findAll();

    Optional<User> findById(String userId);
}
