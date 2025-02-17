package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserEntityRepository userEntityRepository;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity params) {

        UserEntity userEntity = new UserEntity(params.email, params.password);
        return this.userEntityRepository.save(userEntity);
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
        return new UserDto(userId, "test@test.com");
    }

    @PutMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable String userId, @RequestBody UserCreationParams params) {
        return null;
    }

    @DeleteMapping("/users/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return true;
    }

}
