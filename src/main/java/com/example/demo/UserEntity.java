package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


@Entity
public class UserEntity {

    @Id
    private String id;
    private @NotNull @Email String email;
    private @NotNull String password;

    public UserEntity( @NotNull @Email String email, @NotNull String password) {
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public UserEntity() {}

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
