package com.example.demo;

public interface UserService {

   UserCreationParams createUser(UserCreationParams params);
    UserDto getUser(String userId);
    UserDto updateUser(String userId, UserCreationParams params);
    boolean deleteUser(String userId);

}
