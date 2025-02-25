package com.example.demo;

import java.util.UUID;

public final class UserDto {
    public final UUID id;
    public final String email;

    public UserDto(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

}
