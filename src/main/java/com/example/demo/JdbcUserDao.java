package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class JdbcUserDao implements UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Stream<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users.stream();
    }

    @Override
    public Optional<User> findById(int userId) {
        String sql = "select * from users where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", userId);

        User user = jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(User.class));
        return Optional.ofNullable(user);
    }

    @Override
    public User upsert(User user) {
        return null;
    }

    @Override
    public void delete(int userId) {

    }

}
