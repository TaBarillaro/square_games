package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class JdbcUserDao implements UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public JdbcUserDao(NamedParameterJdbcTemplate jdbcTemplate, UserEntityRepository userEntityRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userEntityRepository = userEntityRepository;
    }


    @Override
    public Stream<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users.stream();
    }

    @Override
    public Optional<User> findById(String userId) {
        String sql = "select * from user_entity where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", userId);

        User user = jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(User.class));
        return Optional.ofNullable(user);
    }

    @Override
    public User upsert(@NotNull User userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity = userEntityRepository.save(userEntity);
        return toDto(userEntity);
    }

    private User toDto(UserEntity userEntity) {
        return null;

    }

    @Override
    public void delete(String userId) {

    }

}
