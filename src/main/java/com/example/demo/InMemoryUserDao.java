package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class InMemoryUserDao implements UserDao {

    private ArrayList<String> games = new ArrayList<String>();

    @Override
    public Stream<User> findAll() {
        return Stream.empty();
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return Optional.empty();
    }

    @Override
    public User upsert(User user) {
        return null;
    }

    @Override
    public void delete(UUID userId) {

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
