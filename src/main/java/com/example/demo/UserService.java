package com.example.demo;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    User createUser(User user);
    User getUserById(int userId);
    User updateUser(User user);
    User deleteUser(int userId);

    Stream<User> findAll();

    Optional<User> findById(int userId);
}
