package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {


    @Qualifier("jdbcUserDao")
    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        return userDao.upsert(user);
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> user = userDao.findById(userId);
        return user.orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userDao.upsert(user);
    }

    @Override
    public User deleteUser(int userId) {
        Optional<User> user = userDao.findById(userId);
        if (user.isPresent()) {
            userDao.delete(userId);
            return user.get();
        }
        return null;
    }

    @Override
    public Stream<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(int userId) {
        return userDao.findById(userId);
    }

}
