package com.example.demo;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {
    @NotNull Stream<UserDto> findAll();
    Optional<UserDto> findById(@NotNull UUID userId);
    @NotNull UserDto upsert(@NotNull UserDto user);
    void delete(@NotNull UUID userId);
}
