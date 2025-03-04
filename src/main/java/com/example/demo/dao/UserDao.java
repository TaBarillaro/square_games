package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.entity.UserEntity;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserDao {

    @NotNull Stream<User> findAll();
    Optional<User> findById(String userId);
    @NotNull User upsert(@NotNull User user);
    void delete(String userId);

    UserEntity findByEmail(String username);
}
