package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

//    @Override
//    <S extends UserEntity> S save(S entity);
//
//    @Override
//    void delete(UserEntity entity);

}
