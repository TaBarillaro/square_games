package com.example.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class InMemoryUserDao implements UserDao {

    private ArrayList<String> games = new ArrayList<String>();

    private Map<UUID, User> users = new HashMap<>();

    @Override
    public Stream<User> findAll() {
        return Stream.empty();
    }

    @Override
    public Optional<User> findById(@NotNull @Size(min = 36, max = 36) String userId) {
        try {
            UUID uuid = UUID.fromString(userId);
            return Optional.ofNullable(users.get(uuid));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public User upsert(User user) {
        return null;
    }

    @Override
    public void delete(String userId) {

    }

//    @Override
//    public ArrayList<String> getCurrentGame(String newGame) {
//        games.add(newGame);
//        return games;
//    }
//
//    @Override
//    public boolean updateGame(User user) {
//        return false;
//    }
}
