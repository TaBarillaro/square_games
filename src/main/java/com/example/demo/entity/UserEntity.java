package com.example.demo.entity;

import jakarta.persistence.Entity;
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
    private @NotNull String role;
    private @NotNull boolean enabled;
    private String creationDate;

    public UserEntity(@NotNull @Email String email, @NotNull String password, @NotNull String role, boolean enabled, @NotNull String creationDate) {
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID().toString();
        this.role = role;
        this.enabled = enabled;
        this.creationDate = java.time.LocalDate.now().toString();
    }

    public UserEntity() {}

    public UserEntity(String email, String password) {
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
