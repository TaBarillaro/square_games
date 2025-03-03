package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserCreationParams(@NotNull @Email String email, @NotEmpty String password) {
    public UserCreationParams(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
