package com.example.demo;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserService {

    User createUser(User user);
    User getUserById(UUID userId);
    User updateUser(User user);
    User deleteUser(UUID userId);

    Stream<User> findAll();

    Optional<User> findById(UUID userId);
}
