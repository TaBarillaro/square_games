package com.example.demo;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserCreationParams createUser(UserCreationParams params) {
        return new UserCreationParams(params.getPassword(), params.getEmail());
    }

    @Override
    public UserDto getUser(String userId) {
        return new UserDto(userId, " ");
    }

    @Override
    public UserDto updateUser(String userId, UserCreationParams params) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }
}
