package com.example.demo;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserDao {

    @NotNull Stream<User> findAll();
    Optional<User> findById(int userId);
    @NotNull User upsert(@NotNull User user);
    void delete(int userId);

}
