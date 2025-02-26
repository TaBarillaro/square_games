package com.example.demo;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {

    @NotNull Stream<User> findAll();
    Optional<User> findById(String userId);
    @NotNull User upsert(@NotNull User user);
    void delete(String userId);

}
