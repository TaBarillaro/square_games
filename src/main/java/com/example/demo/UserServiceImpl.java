package com.example.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {


    @Qualifier("jdbcUserDao")
    @Autowired
    private UserDao userDao;

    @Override
    public UserDto createUser(@Validated @NotNull UserCreationParams params) {
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, params.email, params.password);
        return toDto(userDao.upsert(user));

//        return userDao.upsert(user);
    }

    @Override
    public UserDto getUserById(@NotNull @Size(min = 36, max = 36) String userId) {
        User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return toDto(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.upsert(user);
    }

    @Override
    public User deleteUser(String userId) {
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
    public Optional<User> findById(String userId) {
        return userDao.findById(userId);
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getEmail());
    }

}
